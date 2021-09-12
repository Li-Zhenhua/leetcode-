package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。

 */

 //模拟方法想不出来，直接尝试栈
 //由于有*号这个特殊的东西，故需要两个栈，注意这些栈都是记录索引的
/*class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> stackLeftBracket = new ArrayDeque<>();
        Deque<Integer> stackStar = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                stackLeftBracket.push(i);
            }else if(s.charAt(i) == '*'){
                stackStar.push(i);
            }else{
                if(!stackLeftBracket.isEmpty()){
                    stackLeftBracket.pop();
                }else if(!stackStar.isEmpty()){
                    stackStar.pop();
                }else{
                    return false;
                }
            }
        }
        while(!stackLeftBracket.isEmpty()){
            if(stackStar.isEmpty()) return false;
            int leftBracketIndex = stackLeftBracket.pop();
            int starIndex = stackStar.pop();
            if(starIndex < leftBracketIndex) return false;
        }
        return true;
    }
}*/

//官方解答的贪心算法，算出每个位置的可能的left最大值和最小值
/*
如果遇到左括号，则将最小值和最大值分别加 1；

如果遇到右括号，则将最小值和最大值分别减 1；

如果遇到星号，则将最小值减 1，将最大值加 1。

任何情况下，未匹配的左括号数量必须非负，因此当最大值变成负数时，说明没有左括号可以和右括号匹配，返回 false。

当最小值为 0 时，不应将最小值继续减少，以确保最小值非负。

遍历结束时，所有的左括号都应和右括号匹配，因此只有当最小值为 0 时，字符串 s 才是有效的括号字符串。

*/
class Solution {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}


public class _9_12_Q678 {
    
}
