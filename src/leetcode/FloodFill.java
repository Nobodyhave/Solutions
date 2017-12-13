package leetcode;

/**
 * Created by Aleksandr on 30/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/flood-fill
 */
public class FloodFill {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, new boolean[image.length][image[0].length], sr, sc, image[sr][sc], newColor);

        return image;
    }

    public void dfs(int[][] image, boolean[][] marked, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || oldColor != image[row][col] || marked[row][col]) {
            return;
        }

        marked[row][col] = true;
        image[row][col] = newColor;

        for (int[] dir : DIRS) {
            dfs(image, marked, row + dir[0], col + dir[1], oldColor, newColor);
        }
    }
}
