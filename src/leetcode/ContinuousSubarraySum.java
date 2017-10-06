package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/continuous-subarray-sum
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        k = Math.abs(k);

        final Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                int rem = sum % k;
                if (set.contains(k - rem) || (i != 0 && rem == 0)) {
                    return true;
                }
                set.add(k - rem);
            }
        }

        return sum == 0;
    }
}
