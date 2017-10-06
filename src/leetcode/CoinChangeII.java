package leetcode;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/coin-change-2
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        } else if (coins == null || coins.length == 0) {
            return 0;
        }

        final int n = coins.length;
        final int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if (coins[i - 1] == j) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}
