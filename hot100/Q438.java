package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指字母相同，但排列不一定相同的字符串。（原始题目根据示例来看有问题）

提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        int n = s.length(), m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n < m) return ans;
        for (int i = 0; i < m; i++) {
            count[p.charAt(i)-'a']++;
            count[s.charAt(i)-'a']--;
        }
        
        for (int i = m; i < n; i++) {
            for(int j = 0; j < 26; j++){
                if(count[j] != 0) break;
                if(j == 25){
                    ans.add(i-m);
                }
            }
            count[s.charAt(i-m)-'a']++;
            count[s.charAt(i)-'a']--;   
        }
        for(int j = 0; j < 26; j++){
            if(count[j] != 0) break;
            else if(j == 25){
                ans.add(n-m);
            }
        }
        return ans;
    }
}

public class Q438 {
    
}
