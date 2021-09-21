package 每日一题;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */

class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        int index = n-1;
        while(index >= 0){
            if(s.charAt(index) == ' '){
                index--;
                continue;
            }
            break;
        }
        for(int i = index; i >= 0; i--){
            if(s.charAt(i) != ' ') ans++;
            else break;
        }
        return ans;
    }
}

public class _9_21_Q58 {
    
}
