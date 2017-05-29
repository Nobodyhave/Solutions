package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        final int h = matrix.length;
        final int w = matrix[0].length;

        int start = 0, end = h - 1;
        while (start <= end) {
            final int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][w - 1] < target) {
                start = mid + 1;
            } else {
                final int index = Arrays.binarySearch(matrix[mid], target);
                return index >= 0;
            }
        }

        return false;
    }
}
