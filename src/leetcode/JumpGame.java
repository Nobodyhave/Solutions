package leetcode;

/**
 * Created by Aleksandr on 12/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/jump-game
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < i) {
                return false;
            } else {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            }
        }

        return dp[nums.length - 1] > 0;
    }
}

