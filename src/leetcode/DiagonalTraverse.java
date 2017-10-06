package leetcode;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/diagonal-traverse
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        } else if (matrix.length == 1) {
            return matrix[0];
        } else if (matrix[0].length == 1) {
            final int[] result = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                result[i] = matrix[i][0];
            }

            return result;
        }

        final int rows = matrix.length, cols = matrix[0].length;
        final int[] result = new int[rows * cols];

        int row = 0, col = 0, i = 0;
        boolean up = true;
        do {
            result[i++] = matrix[row][col];
            if (row == 0) {
                if (up && col != cols - 1) {
                    col++;
                    up = false;
                } else if (up) {
                    row++;
                    up = false;
                } else {
                    row++;
                    col--;
                }
            } else if (row == rows - 1) {
                if (!up) {
                    col++;
                    up = true;
                } else {
                    row--;
                    col++;
                }
            } else if (col == 0) {
                if (!up) {
                    row++;
                    up = true;
                } else {
                    row--;
                    col++;
                }
            } else if (col == cols - 1) {
                if (up) {
                    row++;
                    up = false;
                } else {
                    row++;
                    col--;
                }
            } else if (up) {
                row--;
                col++;
            } else {
                row++;
                col--;
            }
        } while (i < rows * cols);

        return result;
    }
}
