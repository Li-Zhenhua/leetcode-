package hot100;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */

 //中心扩展法找回文
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int count = 0;

        //长度为1时都是回文
        ans += n;


        //以每一个字母为中心，即奇数长度
        for (int i = 0; i < n; i++) {
            int left = i-1, right = i+1;
            count = 0;
            while(left >= 0 && right < n){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                count++;
                left--;
                right++;
            }
            ans += count;
        }

        //以两个字母中间为中心，即偶数长度
        for (int i = 1; i < n; i++) {
            int left = i-1, right = i;
            count = 0;
            while(left >= 0 && right < n){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                count++;
                left--;
                right++;
            }
            ans += count;
        }
        return ans;
    }
}

public class Q647 {
    
}
