package leetcode;

/**
 * Created by Aleksandr on 05/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reshape-the-matrix
 */
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }

        int index = 0;
        final int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[index / c][index % c] = nums[i][j];
                index++;
            }
        }

        return result;
    }
}
