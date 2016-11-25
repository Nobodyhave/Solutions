package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/between-two-sets
 */
public class BetweenTwoSets {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        final int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        int count = 0;
        outer:
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] % i != 0) {
                    continue outer;
                }
            }
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    continue outer;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
