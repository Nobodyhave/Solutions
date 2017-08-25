package leetcode;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii
 */
public class GuessNumberHighOrLowerII {
    public int getMoneyAmount(int n) {
        if (n < 1) {
            return 0;
        }

        final int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1, j = i + (len - 1); j <= n; i++, j++) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max((k > i ? dp[i][k - 1] : 0), (k < j ? dp[k + 1][j] : 0)));
                }
            }
        }

        return dp[1][n];
    }
}
