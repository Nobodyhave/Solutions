package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/edit-distance
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        final int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j]++;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
