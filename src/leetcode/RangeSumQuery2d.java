package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/range-sum-query-2d-immutable
 */
public class RangeSumQuery2d {
    private int[][] matrix;
    private int[][] prefixSum;

    public RangeSumQuery2d(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        this.matrix = matrix;
        prefixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowCount += matrix[i][j];
                if (i != 0) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + rowCount;
                } else {
                    prefixSum[i][j] = rowCount;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null) {
            return 0;
        }

        return prefixSum[row2][col2]
                - (row1 != 0 ? prefixSum[row1 - 1][col2] : 0)
                - (col1 != 0 ? prefixSum[row2][col1 - 1] : 0)
                + (row1 != 0 && col1 != 0 ? prefixSum[row1 - 1][col1 - 1] : 0);
    }
}
