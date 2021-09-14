package 每日一题;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

提示：

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s 和 dictionary[i] 仅由小写英文字母组成

 */

 //根据数据量大小，应该可以用直接暴力解
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        //其实这里可以也可以直接用Collections的sort方法直接排序
        PriorityQueue<String> pQueue = new PriorityQueue<>((a,b)->{
            //compareTo方法是实现一些常见类型比较的好利器
            if(a.length() == b.length()) return a.compareTo(b);
            else return b.length()-a.length();
        });
        for (String string : dictionary) {
            pQueue.offer(string);
        }
        while(!pQueue.isEmpty()){
            String temp = pQueue.poll();
            int tempLen = temp.length();
            int index1 =0, index2 = 0;
            while(index1 < n){
                if(s.charAt(index1) == temp.charAt(index2)){
                    index2++;
                    if(index2 == tempLen){
                        return temp;
                    }
                }
                index1++;
            }
        }
        return "";
    }
}

public class _9_14_Q524 {
    
}
