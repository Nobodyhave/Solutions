package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/largest-divisible-subset
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        final int[] dp = new int[nums.length];
        final int[] indices = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            indices[i] = i;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    indices[i] = j;
                }
            }
        }

        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        int i = maxIndex;
        while (indices[i] != i) {
            result.add(0, nums[i]);
            i = indices[i];
        }
        result.add(0, dp[i]);

        return result;
    }
}
