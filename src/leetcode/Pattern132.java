package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/132-pattern
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        final int n = nums.length;
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        left.put(nums[0], 1);
        for (int i = 1; i < n; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i < n - 1; i++) {
            final int currentCount = right.get(nums[i]);
            if (currentCount != 1) {
                right.put(nums[i], currentCount - 1);
            } else {
                right.remove(nums[i]);
            }

            final Map.Entry<Integer, Integer> entryK = right.lowerEntry(nums[i]);
            if (entryK != null && left.lowerEntry(entryK.getKey()) != null) {
                return true;
            }

            left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
        }

        return false;
    }
}
