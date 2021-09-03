package 每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

 */


 //第一种方法：排序
/*class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}*/

//第二种方法，最小堆
class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0) return new int[0];
        int n = arr.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(k);
        for (int i = 0; i < n; i++) {
            pQueue.offer(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pQueue.poll();
        }
        return ans;
    }
}

//或者最大堆
/*class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0) return new int[0];
        int n = arr.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b)-> b-a);
        for (int i = 0; i < k; i++) {
            pQueue.offer(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if(arr[i] < pQueue.peek()){
                pQueue.poll();
                pQueue.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pQueue.poll();
        }
        return ans;
    }
}*/

public class _9_3_面试题Q17_14 {
    
}
