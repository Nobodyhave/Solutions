package leetcode;

/**
 * Created by Aleksandr on 17/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/spiral-matrix-ii
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        final int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        goDeeper(matrix, 1, 0);

        return matrix;
    }

    private static void goDeeper(int[][] matrix, int num, int step) {
        final int w = matrix[0].length - 2 * step;
        final int h = matrix.length - 2 * step;

        if (w <= 0 || h <= 0) {
            return;
        }

        for (int i = 0; i < w; i++) {
            matrix[step][i + step] = ++num;
        }
        for (int i = 1; i < h; i++) {
            matrix[i + step][w + step - 1] = ++num;
        }
        for (int i = w - 2; i >= 0; i--) {
            matrix[h + step - 1][i + step] = ++num;
        }
        for (int i = h - 2; i > 0; i--) {
            matrix[i + step][step] = ++num;
        }

        goDeeper(matrix, num, step + 1);
    }
}
