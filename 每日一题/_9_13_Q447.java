package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

返回平面上所有回旋镖的数量。

 */

 //过应该是能过的，就是效率不太行
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if(n <= 2) return 0;
        //其实不用存
        /*int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] point1 = points[i];
            for (int j = i+1; j < n; j++) {
                int[] point2 = points[j];
                int x = point1[0] - point2[0];
                int y = point1[1] - point2[1];
                distance[i][j] = x*x + y*y;
                distance[j][i] = distance[i][j];
            }
        }*/
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //map的key值为距离，value为个数
            Map<Integer,Integer> map = new HashMap<>();
            int[] point1 = points[i];
            for (int j = 0; j < n; j++) {
                int[] point2 = points[j];
                int x = point1[0] - point2[0];
                int y = point1[1] - point2[1];
                int dis = x*x + y*y;
                map.put(dis, map.getOrDefault(dis, 0)+1);
            }  
            for (Integer key : map.keySet()) {
                int num = map.get(key);
                if(num >= 2){
                    //排列数 An2
                    ans += num * (num-1);
                }
            }
        }
        return ans;
    }
}

public class _9_13_Q447 {
    
}
