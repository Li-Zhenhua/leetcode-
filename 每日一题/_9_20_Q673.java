package 每日一题;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 */

 //这题有点没想到，前置知识点可以看300题
 //动态规划是一般做法
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = Integer.MIN_VALUE;
        int ans = 0;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                ans += count[i];
            }
        }
        return ans;
    }
}

public class _9_20_Q673 {
    
}
