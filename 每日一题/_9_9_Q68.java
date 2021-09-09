package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。

 */

 //官方写法，自己写的方法真是又臭又长
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int right = 0, n = words.length;
        while (true) {
            int left = right; // 当前行的第一个单词在 words 的位置
            int sumLen = 0; // 统计这一行单词长度之和
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // 拼接额外加一个空格的单词
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // 拼接其余单词
            ans.add(sb.toString());
        }
    }

    // blank 返回长度为 n 的由空格组成的字符串
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}


//自己写的太垃圾了，都不想看
/*class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int len = 0;
        int preIndex = 0;
        List<String> ans = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            len += words[i].length();
            if(len > maxWidth){
                len -= words[i].length();
                StringBuilder sb = new StringBuilder();
                int stringNum = i - preIndex;
                //注意单词间本来有一个空格
                //如果一个单词就是超过了maxWidth，在if中也算作处理了
                int blankLen = maxWidth - len + stringNum;
                if(stringNum == 1){
                    sb.append(words[preIndex]);
                    for (int j = 0; j < blankLen ; j++) {
                        sb.append(' ');
                    }
                }else{
                    
                    int averageLen = blankLen / (stringNum - 1);
                    int extraNum = blankLen % (stringNum - 1);
                    
                    for (int j = preIndex; j < i-1; j++) {
                        sb.append(words[j]);
                        for (int j2 = 0; j2 < averageLen; j2++) {
                            sb.append(' ');
                        }
                        if(j-preIndex < extraNum){
                            sb.append(' ');
                        }
                    }
                    //最后一个单词
                    sb.append(words[i-1]);
                }

                ans.add(sb.toString());

                //复位
                len = words[i].length() + 1;
                preIndex = i;

            }else if(len == maxWidth){
                StringBuilder sb = new StringBuilder();
                for (int j = preIndex; j < i; j++) {
                    sb.append(words[j] + ' ');
                }
                //最后一个单词
                sb.append(words[i]);
                ans.add(sb.toString());

                //复位
                len = 0;
                preIndex = i+1;
            }else if(len + 1 == maxWidth){
                StringBuilder sb = new StringBuilder();

                //最后一个单词,分成到最后一个元素和没到最后一个元素这两种情况
                //以及要是只有一个单词，那么就只要一个‘ ’
                if(i == n-1 || i == preIndex){
                    sb.append(words[preIndex] + ' ');
                }else{
                    sb.append(words[preIndex] + ' ' + ' ');
                }
                for (int j = preIndex+1; j < i; j++) {
                    sb.append(words[j] + ' ');
                }
                //最后一个单词
                if(preIndex != i){
                    sb.append(words[i]);
                }
                
                ans.add(sb.toString());
                

                //复位
                len = 0;
                preIndex = i+1;
            }
            else{
                len++;
            }
        }

        //处理最后一组词
        if(len != 0){
            StringBuilder sb = new StringBuilder();
            if(preIndex == n-1){
                sb.append(words[preIndex]);
                for (int j = 0; j < maxWidth - len + 1 ; j++) {
                    sb.append(' ');
                }
            }else{
                for (int j = preIndex; j < n; j++) {
                    sb.append(words[j] + ' ');
                }
                for (int j = 0; j < maxWidth - len; j++) {
                    sb.append(' ');
                }
            }
            
            ans.add(sb.toString());
        }


        return ans;
    }
}*/

public class _9_9_Q68 {
    
}
