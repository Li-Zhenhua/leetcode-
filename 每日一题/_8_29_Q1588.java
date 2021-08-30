package 每日一题;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 
 * 子数组 定义为原数组中的一个连续子序列。
 * 
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * 
 */

// 第一想法前缀和
/*
 * class Solution { public int sumOddLengthSubarrays(int[] arr) { int n =
 * arr.length; int ans = 0; for (int i = 1; i < n; i++) { arr[i] += arr[i-1]; }
 * 
 * //窗口大小 int win = 1; while(win <= n){ //由于左边界问题，第一个要单独拿出来 ans += arr[win-1];
 * for (int i = win; i < n; i++) { ans += arr[i] - arr[i-win]; }
 * 
 * win += 2; } return ans; } }
 */

// 题解的数学方法，降维打击
/*
 * 显然，一个包含A[i]的奇数长度的连续子序列只会有两种情况：
 * 
 * 左边和右边的子序列长度【均为奇数】个。 左边和右边的子序列长度【均为偶数】个。
 * 
 * 要从A[0: i-1]序列中，选取连续的、紧靠A[i]的，长度为奇数的子序列 共有(i+1)/2种情况，同理求解其他部分，然后组合
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int LeftOdd = (i+1)/2, LeftEven = i/2+1;
            int RightOdd = (len-i)/2, RightEven = (len-1-i)/2+1;
            res += arr[i]*(LeftOdd*RightOdd + LeftEven*RightEven);
        }
        return res;
    }
}

public class _8_29_Q1588 {

}
