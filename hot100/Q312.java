package hot100;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

求所能获得硬币的最大数量。

 */

 //猜想：先从小到大戳破中间的气球，然后两侧边界的气球也是从小到大戳破
 //好像猜想不对orz
 //要用动态规划，好像数学的方法不行orz
 //dp[i][j] 表示开区间 (i,j) 内你能拿到的最多金币
 //假设最后一个戳破的气球的索引为k，则dp[i][j]可以由 dp[i][k] 和 dp[k][j] 进行转移
 //total = dp[i][k] + val[i] * val[k] * val[j] + dp[k][j]
 //最终要得到结果为dp[0][n+1]
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //左右边界补充值，统一边界两个数的算法
        int[][] dp = new int[n+2][n+2]; 
        int[] numsExpand = new int[n+2];
        numsExpand[0] = 1;
        numsExpand[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            numsExpand[i] = nums[i-1];
        }
        
        for (int i = 0; i < numsExpand.length; i++) {
            
        }
    }
}

public class Q312 {
    
}
