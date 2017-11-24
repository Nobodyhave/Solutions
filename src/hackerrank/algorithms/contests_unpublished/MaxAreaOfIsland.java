package hackerrank.algorithms.contests_unpublished;

/**
 * Created by Aleksandr on 03/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/max-area-of-island
 */
public class MaxAreaOfIsland {
    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        final boolean[][] marked = new boolean[grid.length][grid[0].length];
        int size = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                size = Math.max(size, dfs(grid, marked, i, j));
            }
        }

        return size;
    }

    private int dfs(int[][] grid, boolean[][] marked, int row, int col) {
        if (!isValid(grid, row, col) || marked[row][col] || grid[row][col] == 0) {
            return 0;
        }

        marked[row][col] = true;
        int size = 1;
        for (int[] dir : DIRS) {
            final int r = row + dir[0];
            final int c = col + dir[1];
            size += dfs(grid, marked, r, c);
        }

        return size;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
