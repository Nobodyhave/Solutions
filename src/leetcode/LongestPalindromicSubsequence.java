package leetcode;

/**
 * Created by Aleksandr on 28/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-palindromic-subsequence
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final int dp[][] = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int k = 2; k <= s.length(); k++) {
            for (int r = 0, c = k - 1; c < s.length(); r++, c++) {
                if (s.charAt(r) == s.charAt(c)) {
                    dp[r][c] = 2 + dp[r + 1][c - 1];
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
