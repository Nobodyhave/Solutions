package leetcode;

/**
 * Created by Aleksandr on 28/04/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
