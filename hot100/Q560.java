package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */

 //过是能过，效率不是很高
 //可用map记录前面的前缀和出现的次数
/*class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        if(nums[0] == k) ans++;
        //前缀和
        for(int i = 1; i < n; i++){
            nums[i] += nums[i-1];
            if(nums[i] == k) ans++;
        }

        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = nums[j] - nums[i-1];
                if(temp == k) ans++;
            }
        }
        return ans;
    }
}*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //初始条件，即key=0时表示nums[i]=k
        map.put(0, 1);
        if(nums[0] == k) ans++;
        //注意这里nums[0]与k均有可能为0，导致put的时候应该在上述初始值1的基础上加1
        map.put(nums[0], map.getOrDefault(nums[0], 0)+1);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
            if(map.containsKey(nums[i] - k)){
                ans += map.get(nums[i] - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return ans;
    }
}
public class Q560 {
    
}
