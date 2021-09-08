package 每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。

给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。

最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。

总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。

答案保证在 32 位有符号整数范围内。

 */

 //优先队列+贪心
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = profits[i];
            pair[i][1] = capital[i];
        }
        Arrays.sort(pair,(a,b) -> a[1] - b[1]);

        //由于每次都是贪心选择一个，这里优先队列的大小可以不用固定
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int index = 0;
        //注意这里其实初始资本也是包含在总资本里面的！！！
        //int ans = 0;
        for (int i = 0; i < k; i++) {    
            while(index < n){
                if(pair[index][1] <= w){
                    pQueue.offer(pair[index++]);
                }else{
                    break;
                }
            }
            if(!pQueue.isEmpty()){
                int[] temp = pQueue.poll();
                //ans += temp[0];
                w += temp[0];
            }else{
                //当优先队列为空时，表示已经没有能够执行的任务了
                break;
            }
        }
        //return ans;
        return w;
    }
}

public class _9_8_Q502 {
    
}
