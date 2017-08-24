package leetcode;

/**
 * Created by Aleksandr on 17/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/burst-balloons
 */
public class BurstBalloons {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        // Fill new array, removing zeroes as they don't give value and adding 1 to start and end
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        final int[][] dp = new int[n][n];
        n -= 2;
        for (int len = 1; len <= n; ++len) {
            for (int left = 1; left <= n - len + 1; ++left) {
                int right = left + len - 1;
                for (int k = left; k <= right; ++k) {
                    dp[left][right] = Math.max(
                            dp[left][right],
                            nums[left - 1] * nums[k] * nums[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
}
