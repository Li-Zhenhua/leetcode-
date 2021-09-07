package hot100;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

 //这个先排序按照顺序分组的思维不对
/*class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n <= 1) return false;
        Arrays.sort(nums);
        int left = 1, right = n-2;
        int leftSum = nums[0], rightSum = nums[n-1];
        while(left <= right){
            if(leftSum <= rightSum){
                leftSum += nums[left];
                left++;
            }else{
                rightSum += nums[right];
                right--;
            }
        }
        return leftSum == rightSum;
    }
}*/


//看了题解才发现这就是01背包问题
//dp[i][j]表示下标从0到i的元素是否能选出和为j的集合
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n <= 1) return false;
        int sum = 0, maxNum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        if(sum % 2 != 0) return false;
        //每一个集合的和即为halfSum
        int halfSum = sum / 2;
        //此时其余元素之和一定小于halfSum，故不可能分成两个和相同的集合
        if(maxNum > halfSum) return false;

        boolean[][] dp = new boolean[n][halfSum+1];
        //边界条件
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= halfSum; j++) {
                if(j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][halfSum];
    }
}

public class Q416 {
    
}
