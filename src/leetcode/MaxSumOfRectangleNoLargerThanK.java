package leetcode;

import java.util.TreeSet;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            final int[] curSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int row = 0; row < rows; row++) {
                    curSum[row] += matrix[row][right];
                }
                int curMax = kadanesAlgorithn(curSum, k);
                max = Math.max(max, curMax);
            }
        }

        return max;
    }

    private int kadanesAlgorithn(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int cur = 0;

        final TreeSet<Integer> set = new TreeSet<>();
        set.add(cur);
        for (int i = 0; i < a.length; i++) {
            cur += a[i];
            Integer prefixSum = set.ceiling(cur - k);
            if (prefixSum != null) {
                max = Math.max(max, cur - prefixSum);
            }
            set.add(cur);
        }

        return max;
    }
}
