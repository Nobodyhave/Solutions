package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 14/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/contains-duplicate
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
