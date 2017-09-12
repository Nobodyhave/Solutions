package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/trapping-rain-water-ii
 */
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        final PriorityQueue<Cell> pq = new PriorityQueue<>(1, Comparator.comparingInt(a -> a.height));

        final int m = heights.length;
        final int n = heights[0].length;
        final boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int volume = 0;
        while (!pq.isEmpty()) {
            final Cell cell = pq.poll();
            for (int[] dir : dirs) {
                final int row = cell.row + dir[0];
                final int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    volume += Math.max(0, cell.height - heights[row][col]);
                    pq.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }
            }
        }

        return volume;
    }

    private static class Cell {
        private int row;
        private int col;
        private int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
