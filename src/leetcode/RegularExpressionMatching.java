package leetcode;

/**
 * Created by Aleksandr on 04/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/regular-expression-matching
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        final boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Empty pattern to empty string
        dp[0][0] = true;

        // Non-empty pattern to empty string
        if (p.length() > 0) {
            dp[0][1] = p.charAt(0) == '*';
        }
        for (int i = 2; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        // dp[i][0] is false, as empty pattern doesn't match to non-empty string

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // If pattern matches string explicitly
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If pattern can match string implicitly
                else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        // If no match in current 'a', the a* count as empty
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // If there is match in current 'a', then a* can be empty, multiple a or single a
                        // For empty a we look at state when pattern was 2 letters shorter (exclude a*)
                        // For multiple a we look at state when string was 1 letter shorter with same pattern
                        // For single a we look at state when pattern was 1 letter shorter (a instead of a*)
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];

                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
