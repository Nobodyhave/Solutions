package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/k-diff-pairs-in-an-array
 */
public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }

        final Set<Integer> set = new HashSet<>();
        final Set<Integer> used = new HashSet<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                if (!set.add(nums[i]) && !used.contains(nums[i])) {
                    used.add(nums[i]);
                    count++;
                }
            } else {
                set.add(nums[i]);
            }
        }


        for (Integer num : set) {
            if (k == 0 || used.contains(num)) {
                continue;
            }
            if (set.contains(num + k)) {
                count++;
                used.add(num + k);
            }
            if (set.contains(num - k)) {
                count++;
                used.add(num - k);
            }
            used.add(num);
        }

        return count;
    }
}
