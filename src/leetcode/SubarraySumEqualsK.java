package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 05/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/subarray-sum-equals-k
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum - k;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
