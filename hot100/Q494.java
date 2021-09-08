package hot100;

/**
 * 给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 */

 //又是01背包问题
 //设所有不含符号的元素总和为sum，所有正数之和为x，则所有负数的绝对值之和为sum-x
 //则x-(sum-x)=target => x = (sum+target)/2
 //即转换成容量为x的01背包
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((sum + target) % 2 != 0) return 0;
        int x = (sum + target) / 2;
        //这里x有可能为负数，注意！！！
        if(x < 0){
            x = -x;
        }
        int[] dp = new int[x+1];
        dp[0] = 1;//初始状态，表示总和为0的时候只有全部不选这一种情况
        //一维的转移方程j要从后往前，防止覆盖
        for (int i = 0; i < n; i++) {
            for (int j = x; j >= nums[i]; j--) {
                //选nums[i]和不选nums[i]两种情况的加和
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[x];
    }
}

public class Q494 {
    
}
