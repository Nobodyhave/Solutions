package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 11/09/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-23/challenges/largest-pyramid
 */
public class LargestPyramid {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        long t1 = System.currentTimeMillis();
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int rows = in.nextInt();
            final int cols = in.nextInt();
            final int blocks = in.nextInt();
            int[][] heights = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    heights[row][col] = in.nextInt();
                }
            }

            int maxSize = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    maxSize = Math.max(maxSize, checkStartPoint(heights, row, col, blocks));
                }
            }
            maxSize = maxSize != 0 ? maxSize / 2 + 1 : 0;
            System.out.println(maxSize);
        }
        in.close();
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static int checkStartPoint(int[][] heights, int row, int col, int blocks) {
        final int rows = heights.length;
        final int cols = heights[0].length;
        int maxSize = 0;
        for (int size = 1; size <= Math.min(rows - row, cols - col); size += 2) {
            maxSize = Math.max(maxSize, checkSize(heights, row, col, blocks, size));
        }

        return maxSize;
    }

    private static int checkSize(int[][] heights, int row, int col, int availableBlocks, int size) {
        int totalBlocksUsed = 0;
        for (int r = row, c = col, curHeight = 1; r <= row + (size / 2); r++, c++, curHeight++) {
            final int blocksUsed = checkPerimeter(heights, r, c, size - 2 * (curHeight - 1), curHeight);
            if (blocksUsed < 0 || totalBlocksUsed + blocksUsed > availableBlocks) {
                return -1;
            }
            totalBlocksUsed += blocksUsed;
        }

        return size;
    }

    private static int checkPerimeter(int[][] heights, int row, int col, int size, int curHeight) {
        int blocksUsed = 0;
        // Top row
        for (int c = col; c < col + size; c++) {
            if (heights[row][c] > curHeight) {
                return -1;
            } else {
                blocksUsed += curHeight - heights[row][c];
            }
        }

        // Right column
        for (int r = row + 1; r < row + size; r++) {
            if (heights[r][col + size - 1] > curHeight) {
                return -1;
            } else {
                blocksUsed += curHeight - heights[r][col + size - 1];
            }
        }

        // Bottom row
        for (int c = col; c < col + size - 1; c++) {
            if (heights[row + size - 1][c] > curHeight) {
                return -1;
            } else {
                blocksUsed += curHeight - heights[row + size - 1][c];
            }
        }

        // Left column
        for (int r = row + 1; r < row + size - 1; r++) {
            if (heights[r][col] > curHeight) {
                return -1;
            } else {
                blocksUsed += curHeight - heights[r][col];
            }
        }

        return blocksUsed;
    }
}
