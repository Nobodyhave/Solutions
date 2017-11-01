package leetcode;

/**
 * Created by Aleksandr on 30/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-parenthesis-string
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return s.charAt(0) == '*';
        }

        final boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }

        for (int k = 2; k <= s.length(); k++) {
            for (int l = 0, r = k + l - 1; r < s.length(); l++, r++) {
                if ((s.charAt(l) == '(' || s.charAt(l) == '*') && (s.charAt(r) == ')' || s.charAt(r) == '*')) {
                    if (r - l == 1) {
                        dp[l][r] = true;
                    } else if (dp[l + 1][r - 1]) {
                        dp[l][r] = true;
                    } else {
                        for (int split = l + 1; split <= r; split++) {
                            dp[l][r] |= dp[l][split - 1] && dp[split][r];
                        }
                    }
                } else {
                    dp[l][r] = false;
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
