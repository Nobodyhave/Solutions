package leetcode;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/delete-operation-for-two-strings
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        final int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
