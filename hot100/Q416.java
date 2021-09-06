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

class Solution {
    public boolean canPartition(int[] nums) {

    }
}

public class Q416 {
    
}
