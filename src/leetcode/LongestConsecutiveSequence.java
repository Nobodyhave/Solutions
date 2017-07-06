package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 27/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int best = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int y = num + 1;
                while (set.contains(y)) {
                    y++;
                }

                best = Math.max(best, y - num);
            }
        }

        return best;
    }
}
