package leetcode;

/**
 * Created by Aleksandr on 25/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/image-smoother
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) {
            return new int[0][0];
        }

        final int rows = M.length;
        final int cols = M[0].length;

        final int[] dirs = new int[]{-1, 0, 1};
        final int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0, count = 0;
                for (int hDir : dirs) {
                    for (int vDir : dirs) {
                        final int r = i + vDir;
                        final int c = j + hDir;

                        if (r >= 0 && r < rows && c >= 0 && c < cols) {
                            sum += M[r][c];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
