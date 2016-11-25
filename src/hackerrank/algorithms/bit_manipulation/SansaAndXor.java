package hackerrank.algorithms.bit_manipulation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sansa-and-xor
 */
public class SansaAndXor {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }

            final int[] counts = new int[N];
            counts[0] = N;
            for (int i = 1; i < N; i++) {
                if (i <= N / 2) {
                    counts[i] = counts[i - 1] + (N - i * 2);
                } else {
                    counts[i] = counts[i - 1] - (N - (N - i) * 2);
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (counts[i] % 2 != 0) {
                    result ^= a[i];
                }
            }

            System.out.println(result);
        }
    }
}
