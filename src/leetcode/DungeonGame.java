package leetcode;

/**
 * Created by Aleksandr on 07/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/dungeon-game
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }

        final int rows = dungeon.length;
        final int cols = dungeon[0].length;
        final int[][] dp = new int[rows][cols];

        dp[rows - 1][cols - 1] = Math.max(0, -dungeon[rows - 1][cols - 1]) + 1;

        for (int r = rows - 2; r >= 0; r--) {
            dp[r][cols - 1] = Math.max(dp[r + 1][cols - 1] - dungeon[r][cols - 1], 1);
        }
        for (int c = cols - 2; c >= 0; c--) {
            dp[rows - 1][c] = Math.max(dp[rows - 1][c + 1] - dungeon[rows - 1][c], 1);
        }

        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - 2; c >= 0; c--) {
                dp[r][c] = Math.max(Math.min(dp[r][c + 1], dp[r + 1][c]) - dungeon[r][c], 1);
            }
        }

        return dp[0][0];
    }
}
