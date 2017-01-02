package hackerrank.algorithms.constructive_algorithms;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/flipping-the-matrix
 */
public class FlippingTheMatrix {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int N = in.nextInt();
            final int[][] a = new int[2 * N][2 * N];

            for (int i = 0; i < 2 * N; i++) {
                for (int j = 0; j < 2 * N; j++) {
                    a[i][j] = in.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int adder = a[i][j];
                    adder = Math.max(adder, Math.max(a[2 * N - i - 1][j], a[i][2 * N - j - 1]));
                    adder = Math.max(adder, a[2 * N - i - 1][2 * N - j - 1]);
                    sum += adder;
                }
            }

            System.out.println(sum);
        }
    }
}
