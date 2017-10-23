package leetcode;

/**
 * Created by Aleksandr on 19/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/palindromic-substrings
 */
public class PalindromicSubstring {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        final boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int k = 2; k <= s.length(); k++) {
            for (int i = 0, j = k - 1; j < s.length(); i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
