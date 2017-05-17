package leetcode;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int[] dp = new int[nums.length];
        int maxTotal = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxTotal = Math.max(maxTotal, dp[i]);
        }

        return maxTotal;
    }
}
