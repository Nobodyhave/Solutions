package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 */
public class SearchIn2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}
