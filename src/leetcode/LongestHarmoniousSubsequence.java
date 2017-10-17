package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-harmonious-subsequence
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(nums[i], i);
        }

        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i] - 1)) {
                max = Math.max(max, i - map.get(nums[i] - 1) + 1);
            }
        }

        return max;
    }
}
