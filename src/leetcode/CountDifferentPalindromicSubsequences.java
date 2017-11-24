package leetcode;

import java.util.TreeSet;

/**
 * Created by Aleksandr on 21/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-different-palindromic-subsequences
 */
public class CountDifferentPalindromicSubsequences {
    private static final int MOD = 1000000007;

    public int countPalindromicSubsequences(String S) {
        final TreeSet<Integer>[] characters = new TreeSet[26];
        final int length = S.length();

        for (int i = 0; i < 26; i++) {
            characters[i] = new TreeSet<Integer>();
        }

        for (int i = 0; i < length; ++i) {
            final int c = S.charAt(i) - 'a';
            characters[c].add(i);
        }
        final Integer[][] dp = new Integer[length + 1][length + 1];

        return memo(S, characters, dp, 0, length);
    }

    private int memo(String s, TreeSet<Integer>[] characters, Integer[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        long ans = 0;

        for (int i = 0; i < 26; i++) {
            final Integer newStart = characters[i].ceiling(start);
            final Integer newEnd = characters[i].lower(end);
            if (newStart == null || newEnd == null || newStart >= end) {
                continue;
            }
            ans++;
            if (!newStart.equals(newEnd)) {
                ans++;
            }
            ans += memo(s, characters, dp, newStart + 1, newEnd);

        }
        dp[start][end] = (int) (ans % MOD);

        return dp[start][end];
    }
}
