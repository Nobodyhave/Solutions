package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 27/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 < dp[i]) {
                        // Do nothing
                    } else {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                count += counts[i];
            }
        }

        return count;
    }
}
