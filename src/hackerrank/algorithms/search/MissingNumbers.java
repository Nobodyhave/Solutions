package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/missing-numbers
 */
public class MissingNumbers {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        final int M = in.nextInt();
        final int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            if (B[i] > max) {
                max = B[i];
            }
            if (B[i] < min) {
                min = B[i];
            }
        }

        final int[] counts = new int[max - min + 1];

        for (int i = 0; i < M; i++) {
            counts[B[i] - min]++;
        }
        for (int i = 0; i < N; i++) {
            counts[A[i] - min]--;
        }
        //System.out.println("Min: " + min + " Max: " + max);
        //System.out.println(Arrays.toString(counts));
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.print((min + i) + " ");
            }
        }
    }
}
