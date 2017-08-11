package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 14/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/contains-duplicate-iii
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0) {
            return false;
        } else if (t == 0) {
            return containsNearbyDuplicate(nums, k);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= (long) t) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer prev = map.get(nums[i]);
            if (prev == null) {
                map.put(nums[i], i);
            } else if (i - prev > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }

        return false;
    }
}
