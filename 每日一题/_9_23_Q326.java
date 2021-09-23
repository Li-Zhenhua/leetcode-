package 每日一题;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x

 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        int num = 1;
        //注意控制溢出
        while(num > 0 && num < n){
            num *= 3;
        }
        if(num == n) return true;
        return false;
    }
}

public class _9_23_Q326 {
    
}
