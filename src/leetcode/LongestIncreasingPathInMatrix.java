package leetcode;

/**
 * Created by Aleksandr on 22/08/2017.
 * Project Solutions
 */
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dpPrev = new int[rows][cols];
        int[][] dpCur = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dpPrev[i][j] = 1;
            }
        }

        int result = 0;
        for(int len = 2; len <= rows*cols; len++) {
            boolean isFound = false;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(dpPrev[i][j] == -1) {
                        dpCur[i][j] = -1;
                        continue;
                    }

                    if(i != 0 && matrix[i][j] > matrix[i-1][j] && dpPrev[i-1][j] != -1) {
                        dpCur[i][j] = Math.max(dpCur[i][j], dpPrev[i-1][j] + 1);
                        isFound = true;
                    }
                    if(j != 0 && matrix[i][j] > matrix[i][j-1] && dpPrev[i][j-1] != -1) {
                        dpCur[i][j] = Math.max(dpCur[i][j], dpPrev[i][j-1] + 1);
                        isFound = true;
                    }
                    if(i != rows-1 && matrix[i][j] > matrix[i+1][j] && dpPrev[i+1][j] != -1) {
                        dpCur[i][j] = Math.max(dpCur[i][j], dpPrev[i+1][j] + 1);
                        isFound = true;
                    }
                    if(j != cols-1 && matrix[i][j] > matrix[i][j+1] && dpPrev[i][j+1] != -1) {
                        dpCur[i][j] = Math.max(dpCur[i][j], dpPrev[i][j+1] + 1);
                        isFound = true;
                    }

                    if(dpCur[i][j] != len) {
                        dpCur[i][j] = -1;
                    }
                }
            }
            if(isFound) {
                result = len;
                final int[][] temp = dpCur;
                dpCur = dpPrev;
                dpPrev = temp;
            } else {
                break;
            }
        }

        return result;
    }
}
