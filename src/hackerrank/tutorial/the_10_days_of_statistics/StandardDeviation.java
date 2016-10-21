package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-standard-deviation
 */

import java.util.Scanner;

public class StandardDeviation {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();

        final int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        final double mean = (double) sum / n;
        double squaredDiff = 0;
        for (int i = 0; i < n; i++) {
            squaredDiff += Math.pow(a[i] - mean, 2);
        }

        final double sd = Math.sqrt(squaredDiff / n);

        System.out.format("%.1f", sd);
    }
}
