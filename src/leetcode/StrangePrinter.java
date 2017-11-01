package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 25/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/strange-printer
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 1;
        }

        for (int k = 2; k <= s.length(); k++) {
            for (int left = 0, right = k - 1; right < s.length(); left++, right++) {
                dp[left][right] = right - left + 1;
                for (int split = left; split < right; split++) {
                    int temp = dp[left][split] + dp[split + 1][right];
                    if (s.charAt(split) == s.charAt(right)) {
                        temp--;
                    }
                    dp[left][right] = Math.min(temp, dp[left][right]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
