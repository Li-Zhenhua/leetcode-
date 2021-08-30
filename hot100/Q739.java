package hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */

 //二重循环强算的方法，可以过是可以过，但是效率奇低
/*class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int index = i+1;
            while(index < n && temperatures[i] >= temperatures[index]){
                index++;
            }
            if(index < n){
                ans[i] = index - i;
            }
        }
        return ans;
    }
}*/

//尝试用单调栈
//也可以不用指针模拟，直接使用stack，注意入栈元素应该是索引值
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        //Deque<Integer> stack = new LinkedList<>();
        int bottom = 0, top = 0, curr = 1;
        while(curr < n){
            while(bottom <= top && temperatures[top] < temperatures[curr]){
                if(ans[top] == 0){
                    ans[top] = curr - top;
                }
                top--;
            }
            //bottom > top表示原来栈底的元素也被弹出去了
            //也就是栈底的元素找到了下一次对应的温度增大的位置
            if(bottom > top){
                bottom = curr;
                top = bottom;
            }else{
                top = curr;
            }
            curr++;
            
        }
        return ans;
    }
}

public class Q739 {
    
}
