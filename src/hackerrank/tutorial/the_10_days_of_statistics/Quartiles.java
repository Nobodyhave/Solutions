package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-quartiles
 */

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);

        double q1, q2, q3;
        if (n % 2 == 0) {
            q1 = findMedian(a, 0, n / 2 - 1);
            q2 = findMedian(a, 0, n - 1);
            q3 = findMedian(a, n / 2, n - 1);
        } else {
            q1 = findMedian(a, 0, n / 2 - 1);
            q2 = findMedian(a, 0, n - 1);
            q3 = findMedian(a, n / 2 + 1, n - 1);
        }

        System.out.format("%.0f\n%.0f\n%.0f", q1, q2, q3);
    }

    private static double findMedian(int[] a, int start, int end) {
        final int size = end - start + 1;
        if (size % 2 == 0) {
            return (a[start + size / 2 - 1] + a[start + size / 2]) / 2.0;
        } else {
            return a[start + size / 2];
        }
    }
}
