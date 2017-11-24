package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/spiral-order-matrix-i/
 */
public class SpiralOrderMatrixI {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();

        if (a == null || a.size() == 0 || a.get(0).size() == 0) {
            return result;
        }

        goDeeper(result, a, 0);

        return result;
    }

    private static void goDeeper(List<Integer> result, List<ArrayList<Integer>> matrix, int step) {
        final int w = matrix.get(0).size() - 2 * step;
        final int h = matrix.size() - 2 * step;

        if (w == 0 || h == 0) {
            return;
        } else if (w == 1) {
            for (int i = 0; i < h; i++) {
                result.add(matrix.get(i + step).get(step));
            }
            return;
        } else if (h == 1) {
            for (int i = 0; i < w; i++) {
                result.add(matrix.get(step).get(i + step));
            }
            return;
        }

        for (int i = 0; i < w; i++) {
            result.add(matrix.get(step).get(i + step));
        }
        for (int i = 1; i < h; i++) {
            result.add(matrix.get(i + step).get(w + step - 1));
        }
        for (int i = w - 2; i >= 0; i--) {
            result.add(matrix.get(h + step - 1).get(i + step));
        }
        for (int i = h - 2; i > 0; i--) {
            result.add(matrix.get(i + step).get(step));
        }

        goDeeper(result, matrix, step + 1);
    }
}
