package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/partition-equal-subset-sum
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) != 0) {
            return false;
        } else {
            sum /= 2;
        }


        final int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][sum] == sum;
    }
}
