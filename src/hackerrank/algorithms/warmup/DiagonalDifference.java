package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/diagonal-difference
 */

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int sumF = 0, sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final int num = s.nextInt();
                if (i == j) {
                    sumF += num;
                }
                if (i + j == N - 1) {
                    sumB += num;
                }
            }
        }
        s.close();

        System.out.println(Math.abs(sumF - sumB));
    }
}
