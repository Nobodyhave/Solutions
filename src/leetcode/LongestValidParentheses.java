package leetcode;

/**
 * Created by Aleksandr on 09/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-valid-parentheses
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty() || s.length() < 2) {
            return 0;
        }

        final int[] dp = new int[s.length()];

        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // If we appending () to previous solution
                    dp[i] = (i - 2 >= 0) ? dp[i - 2] + 2 : 2;
                    max = Math.max(max, dp[i]);
                } else {
                    // If we wrap previous solution like (solution)
                    // And also we should check, that before wrapping there was some solution like prevSolution(solution)
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                        max = Math.max(max, dp[i]);
                    }
                }
            } else {
                // Skip, as at this point sequence is incomplete and longest is 0
            }
        }

        return max;
    }
}
