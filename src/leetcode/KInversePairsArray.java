package leetcode;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/k-inverse-pairs-array
 */
public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        final int mod = 1000000007;
        if (k > n * (n - 1) / 2 || k < 0) {
            return 0;
        }
        if (k == 0 || k == n * (n - 1) / 2) {
            return 1;
        }

        final long[][] dp = new long[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[n][k];
    }
}
