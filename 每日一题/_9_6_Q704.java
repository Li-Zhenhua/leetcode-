package 每日一题;

//就是二分查找
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}

public class _9_6_Q704 {
    
}
