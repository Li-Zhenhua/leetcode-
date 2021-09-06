package 每日一题;

/**
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。

给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

注意：分割得到的每个字符串都必须是平衡字符串。

返回可以通过分割得到的平衡字符串的 最大数量 。

 */

 //要尽可能多，那么分割成的每一个平衡字符串尽量短
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int n = s.length();
        int count = 0;
        //false表示每一个平衡字符串的第一个字母为'L'，反之为'R'
        boolean flag = false; 
        for (int i = 0; i < n; i++) {
            if(count == 0){
                ans++; //ans初始值为0就可以不用在最后退出循环后处理最后一部分的1
                if(s.charAt(i) == 'R'){
                    flag = true;
                }else{
                    flag = false;
                }
                count++;
                continue;
            }

            if(flag){
                if(s.charAt(i) == 'L'){
                    count--;
                }else{
                    count++;
                }
            }else{
                if(s.charAt(i) == 'L'){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return ans;
    }
}

public class _9_7_Q1221 {
    
}
