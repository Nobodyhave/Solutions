package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 18/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/permutation-equation
 */
public class SequenceEquation {
    public static void main(String args[]) throws Exception {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] a = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i < N + 1; i++) {
            outer:
            for (int j = 1; j < N + 1; j++) {
                if (a[j] == i) {
                    for (int k = 1; k < N + 1; k++) {
                        if (a[k] == j) {
                            System.out.println(k);
                            break outer;
                        }
                    }
                }
            }
        }
    }
}
