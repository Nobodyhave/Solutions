package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 17/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/spiral-matrix
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        goDeeper(result, matrix, 0);

        return result;
    }

    private static void goDeeper(List<Integer> result, int[][] matrix, int step) {
        final int w = matrix[0].length - 2 * step;
        final int h = matrix.length - 2 * step;

        if (w == 0 || h == 0) {
            return;
        } else if (w == 1) {
            for (int i = 0; i < h; i++) {
                result.add(matrix[i + step][step]);
            }
            return;
        } else if (h == 1) {
            for (int i = 0; i < w; i++) {
                result.add(matrix[step][i + step]);
            }
            return;
        }

        for (int i = 0; i < w; i++) {
            result.add(matrix[step][i + step]);
        }
        for (int i = 1; i < h; i++) {
            result.add(matrix[i + step][w + step - 1]);
        }
        for (int i = w - 2; i >= 0; i--) {
            result.add(matrix[h + step - 1][i + step]);
        }
        for (int i = h - 2; i > 0; i--) {
            result.add(matrix[i + step][step]);
        }

        goDeeper(result, matrix, step + 1);
    }
}
