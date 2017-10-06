package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/01-matrix
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0][0];
        }

        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int[][] dist = new int[rows][cols];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE - 1);
        }
        final boolean[][] marked = new boolean[rows][cols];
        final Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    marked[i][j] = true;
                    if (i != 0 && !marked[i - 1][j]) {
                        queue.add((i - 1) * cols + j);
                        marked[i - 1][j] = true;
                    }
                    if (i != rows - 1 && !marked[i + 1][j]) {
                        queue.add((i + 1) * cols + j);
                        marked[i + 1][j] = true;
                    }
                    if (j != 0 && !marked[i][j - 1]) {
                        queue.add(i * cols + j - 1);
                        marked[i][j - 1] = true;
                    }
                    if (j != cols - 1 && !marked[i][j + 1]) {
                        queue.add(i * cols + j + 1);
                        marked[i][j + 1] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            int min = dist[i][j];
            if (i != 0) {
                min = Math.min(min, dist[i - 1][j] + 1);
                if (!marked[i - 1][j]) {
                    queue.add((i - 1) * cols + j);
                    marked[i - 1][j] = true;
                }
            }
            if (i != rows - 1) {
                min = Math.min(min, dist[i + 1][j] + 1);
                if (!marked[i + 1][j]) {
                    queue.add((i + 1) * cols + j);
                    marked[i + 1][j] = true;
                }
            }
            if (j != 0) {
                min = Math.min(min, dist[i][j - 1] + 1);
                if (!marked[i][j - 1]) {
                    queue.add(i * cols + j - 1);
                    marked[i][j - 1] = true;
                }
            }
            if (j != cols - 1) {
                min = Math.min(min, dist[i][j + 1] + 1);
                if (!marked[i][j + 1]) {
                    queue.add(i * cols + j + 1);
                    marked[i][j + 1] = true;
                }
            }
            dist[i][j] = min;
        }

        return dist;
    }
}
