package leetcode;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/2-keys-keyboard
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n < 1) {
            return 0;
        }

        final int[][] dp = new int[n + 1][n + 1];

        for (int i = 2; i <= n; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < 2 * i) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == 2 * i) {
                    dp[i][j] = dp[i][j - i] + 2;
                } else if (j % i == 0) {
                    dp[i][j] = dp[i][j - i] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];
    }
}
