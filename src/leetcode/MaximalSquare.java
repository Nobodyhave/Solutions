package leetcode;

/**
 * Created by Aleksandr on 14/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/maximal-square
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        final int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int side = 0;

        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    side = Math.max(side, dp[i][j]);
                }
            }
        }

        return side*side;
    }
}
