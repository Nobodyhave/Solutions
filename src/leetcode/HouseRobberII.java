package leetcode;

/**
 * Created by Aleksandr on 11/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/house-robber-ii
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private static int rob(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        } else if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }

        final int[] dp = new int[nums.length - 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[dp.length - 1];
    }
}
