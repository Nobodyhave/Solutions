package leetcode;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/island-perimeter
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (i == 0 || grid[i - 1][j] == 0) {
                    perimeter++;
                }
                if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                    perimeter++;
                }
                if (j == 0 || grid[i][j - 1] == 0) {
                    perimeter++;
                }
                if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                    perimeter++;
                }
            }
        }

        return perimeter;
    }
}
