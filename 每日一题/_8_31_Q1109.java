package 每日一题;
/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。

有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。

请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。

 */

 //能想到的就是这种直接算，没想到还有一种类似前缀和的差分数组的做法
/*class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] booking : bookings){
            int end = booking[1];
            int num = booking[2];
            for(int i = booking[0]-1; i < end; i++){
                ans[i] += num;
            }
        }
        return ans;
    }
}*/

//官方差分数组的方法
//因为是一段连续的相同数字，故只需要记录该段区间左右变化的大小即可，即差分
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

public class _8_31_Q1109 {
    
}
