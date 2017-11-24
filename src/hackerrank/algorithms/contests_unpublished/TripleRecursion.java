package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 */
public class TripleRecursion {
    private static void tripleRecursion(int n, int m, int k) {
        final int[][] matrix = new int[n][n];

        matrix[0][0] = m;
        for (int i = 1; i < n; i++) {
            matrix[i][i] = matrix[i - 1][i - 1] + k;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] - 1;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                matrix[i][j] = matrix[i - 1][j] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        in.close();
    }
}
