package leetcode;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }

        int m = 1;
        while (m * m <= n) {
            m++;
        }
        m--;

        final int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i * i) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == i * i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i][j - i * i] + 1, dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
