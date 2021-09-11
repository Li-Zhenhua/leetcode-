package 每日一题;

/**
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 */

class Solution {
    public int findIntegers(int n) {
        //因为int整数不会超过32位
        int[] f = new int[32];
        int ans = 0;
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        //从最高位开始计算，n最大为10^9
        int index = 30;
        boolean preBit = false;
        while(index >= 0){
            if((n & (1 << index)) != 0){
                //注意此时假设当前位为0，故个数可以加到最终结果中
                ans += f[index]; // 因为下标和二进制长度正好差1，故不用减一
                if(preBit) return ans; //已经存在连续的1了，故直接返回
                preBit = true;
            }else{
                preBit = false;
            }
            index--;
        }
        //注意当程序能执行到这里时，说明所有的1都是不连续的
        //所以还要加上n本身，也就是说n也是一个合法的数
        return ans+1;
    }
}

public class _9_11_Q600 {
    
}
