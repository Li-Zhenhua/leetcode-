package 每日一题;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

提示：

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]

 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        // if(nums[0] > nums[1]) return 0;
        // if(nums[n-2] < nums[n-1]) return n-1;
        // int left = 1, right = n-2;
        int left = 0, right = n-1;
        while(left < right){
            //除了峰值以外，其余元素应该都是单调的
            //注意题设条件元素不重复！！！所以其实很好做判断
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            // }else if(nums[mid] == nums[mid+1]){
            //     right = mid-1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

public class _9_15_Q162 {
    
}
