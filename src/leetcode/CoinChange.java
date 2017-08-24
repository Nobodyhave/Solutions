package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 18/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/coin-change
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) {
            return 0;
        }

        final int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = 0;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i][j] = i != 0 ? dp[i - 1][j] : -1;
                } else if (j >= coins[i]) {
                    if (i != 0 && dp[i - 1][j] != -1 && dp[i][j - coins[i]] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    } else if (i != 0 && dp[i - 1][j] != -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i][j - coins[i]] != -1) {
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}
