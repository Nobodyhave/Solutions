package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/russian-doll-envelopes
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int max = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
