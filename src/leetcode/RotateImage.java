package leetcode;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/rotate-image
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }

        final int n = matrix.length;
        final int layers = n / 2;

        for (int l = 0; l < layers; l++) {
            for (int c = l; c < n - l - 1; c++) {
                final int temp = matrix[l][c];
                matrix[l][c] = matrix[n - 1 - c][l];
                matrix[n - 1 - c][l] = matrix[n - 1 - l][n - 1 - c];
                matrix[n - 1 - l][n - 1 - c] = matrix[c][n - 1 - l];
                matrix[c][n - 1 - l] = temp;
            }
        }
    }
}
