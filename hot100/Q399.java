package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 */

 //日常dfs，因为map映射的值是不同变量，所以需要一个Node节点来存储
class Solution {
    class Node{
        public String s;
        public double value;
        public Node(String s,double value){
            this.s = s;
            this.value = value;
        }
    }

    Map<String,List<Node>> map = new HashMap<>();
    Set<String> set;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        //int n = equations.size();
        double[] ans = new double[queries.size()];

        int index = 0;
        for (List<String> equation : equations) {
            String s1 = equation.get(0);
            String s2 = equation.get(1);

            List<Node> temp = map.getOrDefault(s1, new ArrayList<>());
            temp.add(new Node(s2, values[index]));
            map.put(s1, temp);
            temp = map.getOrDefault(s2, new ArrayList<>());
            temp.add(new Node(s1, 1.0/values[index]));
            map.put(s2, temp);
            index++;
        }

        index = 0;
        for (List<String> query : queries) {
            set = new HashSet<>();
            ans[index++] = dfs(query.get(0), query.get(1), 1.0);
        }
        return ans;
    }

    //preProduct表示之前计算的乘积值，set保存已经走过的节点
    public double dfs(String curr, String last, double preProduct){
        if(!map.containsKey(curr) || set.contains(curr)){
            return -1.0;
        }

        if(curr.equals(last)){
            return preProduct;
        }

        set.add(curr);
        List<Node> next = map.get(curr);
        for (Node node : next) {
            double res = dfs(node.s, last, preProduct*node.value);
            if(res != -1.0){
                return res;
            }
        }

        //没有找到合适路径
        return -1.0;
    }
}

public class Q399 {
    
}
