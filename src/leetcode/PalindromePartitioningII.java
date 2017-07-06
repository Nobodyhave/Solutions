package leetcode;

/**
 * Created by Aleksandr on 28/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/palindrome-partitioning-ii
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final boolean[][] dp = new boolean[s.length()][s.length()];
        final int[] cuts = new int[s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            cuts[i] = s.length() - i - 1;
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j == s.length() - 1) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                    }
                }
            }
        }

        return cuts[0];
    }
}
