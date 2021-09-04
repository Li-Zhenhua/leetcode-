package 每日一题;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1; 
        final int MOD =1000000007;
        int pre1 = 0;
        int pre2 = 1;
        int curr;
        for(int i = 2; i <= n; i++){
            curr = (pre1 + pre2) % MOD;
            pre1 = pre2;
            pre2 = curr;
        }
        return pre2;
    }
}

public class _9_4_剑指Q10 {
    
}
