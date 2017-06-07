package leetcode;

/**
 * Created by Aleksandr on 06/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/decode-ways
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        final int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            final char cur = s.charAt(i - 1);
            final char prev = s.charAt(i - 2);

            if (cur >= '1' && cur <= '9') {
                dp[i] += dp[i - 1];
            }
            if (prev == '1' || (prev == '2' && cur <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
