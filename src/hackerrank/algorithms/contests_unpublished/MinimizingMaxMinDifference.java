package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack43/challenges/max-min-difference
 */
public class MinimizingMaxMinDifference {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        Arrays.sort(a);

        if (a[n - 2] - a[0] < a[n - 1] - a[1]) {
            System.out.println(a[n - 2] - a[0]);
        } else {
            System.out.println(a[n - 1] - a[1]);
        }
    }
}
