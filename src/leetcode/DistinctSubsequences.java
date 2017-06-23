package leetcode;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/distinct-subsequences
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        final int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1) && i >= j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
