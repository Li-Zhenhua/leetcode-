package 每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

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
/*class Solution {
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
}*/

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

//基于快速排序思想
//快排每次都会将小于等于基准值的值放到左边，将大于基准值的值放到右边
/*
idx < k：基准点左侧不足 k 个，递归处理右边，让基准点下标右移；
idx > k：基准点左侧超过 k 个，递归处理左边，让基准点下标左移；
idx = k：基准点左侧恰好 k 个，输出基准点左侧元素。

*/
//这种想法可以记一记
class Solution {
    int k;
    public int[] smallestK(int[] arr, int _k) {
        k = _k;
        int n = arr.length;
        int[] ans = new int[k];
        if (k == 0) return ans;
        qsort(arr, 0, n - 1);
        for (int i = 0; i < k; i++) ans[i] = arr[i];
        return ans;
    }
    void qsort(int[] arr, int l, int r) {
        if (l >= r) return ;
        int i = l, j = r;
        int ridx = new Random().nextInt(r - l + 1) + l;
        swap(arr, ridx, l);
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) j--;
            while (i < j && arr[i] <= x) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 集中答疑：因为题解是使用「基准点左侧」来进行描述（不包含基准点的意思），所以这里用的 k（写成 k - 1 也可以滴
        if (i > k) qsort(arr, l, i - 1);
        if (i < k) qsort(arr, i + 1, r);
    }
    void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}


public class _9_3_面试题Q17_14 {
    
}
