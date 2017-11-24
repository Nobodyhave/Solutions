package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/11/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w35/challenges/3d-surface-area
 */
public class SurfaceArea3D {
    private static int surfaceArea(int[][] A) {
        return calculateTop(A)
                + calculateBottom(A)
                + calculateFront(A)
                + calculateBack(A)
                + calculateLeft(A)
                + calculateRight(A);
    }

    private static int calculateTop(int[][] A) {
        return A.length * A[0].length;
    }

    private static int calculateBottom(int[][] A) {
        return A.length * A[0].length;
    }

    private static int calculateLeft(int[][] A) {
        int sum = 0;
        for (int[] row : A) {
            sum += row[0];
            for (int j = 1; j < A[0].length; j++) {
                sum += Math.max(0, row[j] - row[j - 1]);
            }
        }

        return sum;
    }

    private static int calculateRight(int[][] A) {
        int sum = 0;
        for (int[] row : A) {
            sum += row[A[0].length - 1];
            for (int j = A[0].length - 2; j >= 0; j--) {
                sum += Math.max(0, row[j] - row[j + 1]);
            }
        }

        return sum;
    }

    private static int calculateFront(int[][] A) {
        int sum = 0;
        for (int j = 0; j < A[0].length; j++) {
            sum += A[A.length - 1][j];
            for (int i = A.length - 2; i >= 0; i--) {
                sum += Math.max(0, A[i][j] - A[i + 1][j]);
            }
        }

        return sum;
    }

    private static int calculateBack(int[][] A) {
        int sum = 0;
        for (int j = 0; j < A[0].length; j++) {
            sum += A[0][j];
            for (int i = 1; i < A.length; i++) {
                sum += Math.max(0, A[i][j] - A[i - 1][j]);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int H = in.nextInt();
        final int W = in.nextInt();
        final int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
