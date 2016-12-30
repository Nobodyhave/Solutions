package hackerrank.algorithms.dynamic_programming;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/counting-special-sub-cubes
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingSpecialSubCubes {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();

        for (int q = 0; q < Q; q++) {
            final int N = in.nextInt();
            final int[][][] cube = new int[N + 1][N + 1][N + 1];

            final int squareOfN = N * N;
            final int cubeOfN = N * N * N;
            final int[] nums = new int[cubeOfN + 1];
            for (int i = 1; i <= cubeOfN; i++) {
                nums[i] = in.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        cube[i][j][k] = nums[(i - 1) * squareOfN + (j - 1) * N + k];
                    }
                }
            }

            final int[] counts = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        for (int l = N; l >= cube[i][j][k]; l--) {
                            if (i > N - l + 1) {
                                continue;
                            }
                            if (j > N - l + 1) {
                                continue;
                            }
                            if (k > N - l + 1) {
                                continue;
                            }

                            final int nextSize = checkSubCube(cube, i, j, k, l);
                            if (nextSize == 0) {
                                counts[l]++;
                            } else {
                                l = nextSize;
                            }
                        }
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                System.out.print(counts[i] + " ");
            }

            System.out.println();
        }
    }

    private static int checkSubCube(int[][][] cube, int row, int col, int depth, int size) {
        int max = -1;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                for (int k = depth; k < depth + size; k++) {
                    if (cube[i][j][k] > size) {
                        return Math.max(Math.max(i - row + 1, j - col + 1), k - depth + 1);
                    } else if (cube[i][j][k] == size) {
                        max = 0;
                    }
                }
            }
        }

        return max == 0 ? 0 : size;
    }
}
