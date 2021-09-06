package hot100;


/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。

然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 最短时间 。
 */

 //这题使用一种桶的思想
 //桶的个数num即为最多的字母的个数maxCount
 //求出个数等于num的的字母的数量k，此即为最后一个桶中会包含的元素的个数
 //而后先假设桶的容量为n+1（因为每个重复task中间需要另外的n个元素），
 //则其余num-1个桶最多总共的容量为（num-1）*（n+1)
 //若这些桶未能将除最后一个桶中的元素外剩余的的tasks装完，则可直接扩大桶的容量
 //即相当于两个A任务之间的其他任务的个数不止n个
 //所以此时（num-1）*（n+1)+k与初始tasks的个数的最大值即为所需的最小时间
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //int ans = 0;
        int[] count = new int[26];
        for (char task : tasks) {
            count[task-'A']++;
        }
        int maxCount = 0;
        int k = 1; //最后一个桶中元素的个数，即等于maxCount的任务的个数
        for (int i = 0; i < 26; i++) {
            if(count[i] > maxCount){
                maxCount = count[i];
                k = 1;
            }else if(count[i] == maxCount){
                k++;
            }
        }
        return Math.max(tasks.length, (maxCount-1)*(n+1)+k);
    }
}

public class Q621 {
    
}
