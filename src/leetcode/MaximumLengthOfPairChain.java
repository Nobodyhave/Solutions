package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aleksandr on 19/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-length-of-pair-chain
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        } else if (pairs.length == 1) {
            return 1;
        }

        Arrays.sort(pairs, new LeftComparator());

        final int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[pairs.length - 1];
    }

    private static class LeftComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a1, int[] a2) {
            int result = Integer.compare(a1[0], a2[0]);

            if (result == 0) {
                result = Integer.compare(a1[1], a2[1]);
            }

            return result;
        }
    }
}
