package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksandr on 13/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/degree-of-an-array
 */
public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int[] counts = new int[50000];
        for (int num : nums) {
            counts[num]++;
        }

        final Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                map.computeIfAbsent(counts[i], key -> new HashSet<>());
                map.get(counts[i]).add(i);
                maxCount = Math.max(maxCount, counts[i]);
            }
        }

        final Map<Integer, int[]> intervals = new HashMap<>();
        final Set<Integer> maxValues = map.get(maxCount);
        for (Integer value : maxValues) {
            intervals.put(value, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxValues.contains(nums[i])) {
                final int[] interval = intervals.get(nums[i]);
                interval[0] = Math.min(interval[0], i);
                interval[1] = Math.max(interval[1], i);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int[] interval : intervals.values()) {
            result = Math.min(result, interval[1] - interval[0] + 1);
        }

        return result;
    }
}
