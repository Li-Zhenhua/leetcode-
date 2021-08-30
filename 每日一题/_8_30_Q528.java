package 每日一题;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。

例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

也就是说，选取下标 i 的概率为 w[i] / sum(w) 。

提示：

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex 将被调用不超过 10000 次

 */

class Solution {

    double[] probability;
    int n;
    int total = 0;
    public Solution(int[] w) {
        n = w.length;
        probability = new double[n];
        //total = Arrays.stream(w).sum();
        for (int i = 0; i < n; i++) {
            total += w[i];
        }

        //probability[0] = w[0];
        //前缀和
        //注意要类型转换
        probability[0] =  (double)w[0] / total;
        for (int i = 1; i < n; i++) {
            w[i] += w[i-1];
            probability[i] =  (double)w[i] / total;
        }

    }
    
    public int pickIndex() {
        double r = Math.random();
        //Random random = new Random();
        //double r = random.nextDouble();

        //可以二分查找优化
        for (int i = 0; i < n; i++) {
            if(r < probability[i]){
                return i;
            }
        }
        
        return n-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

public class _8_30_Q528 {
    
}
