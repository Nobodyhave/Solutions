package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/wiggle-subsequence
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        final int[] inc = new int[nums.length];
        final int[] dec = new int[nums.length];

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    inc[i] = Math.max(inc[i], dec[j] + 1);
                } else if (nums[i] < nums[j]) {
                    dec[i] = Math.max(dec[i], inc[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, Math.max(inc[i], dec[i]));
        }

        return max;
    }
}
