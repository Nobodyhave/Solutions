package leetcode;

import java.util.List;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/triangle
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int[] dpPrev = new int[triangle.size()];
        dpPrev[0] = triangle.get(0).get(0);
        int[] dpCur = new int[triangle.size()];

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dpCur[j] = dpPrev[j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dpCur[j] = dpPrev[j - 1] + triangle.get(i).get(j);
                } else {
                    dpCur[j] = triangle.get(i).get(j) + Math.min(dpPrev[j - 1], dpPrev[j]);
                }
            }

            final int[] temp = dpPrev;
            dpPrev = dpCur;
            dpCur = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dpPrev.length; i++) {
            if (dpPrev[i] < min) {
                min = dpPrev[i];
            }
        }

        return min;
    }
}
