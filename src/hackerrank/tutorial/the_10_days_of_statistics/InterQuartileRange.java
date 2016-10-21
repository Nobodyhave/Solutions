package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-interquartile-range
 */

import java.util.Arrays;
import java.util.Scanner;

public class InterQuartileRange {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }

        final int[] f = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            f[i] = in.nextInt();
            count += f[i];
        }

        final int[] a = new int[count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < f[i]; j++) {
                a[k++] = x[i];
            }
        }

        Arrays.sort(a);

        double q1, q3;
        if (count % 2 == 0) {
            q1 = findMedian(a, 0, count / 2 - 1);
            q3 = findMedian(a, count / 2, count - 1);
        } else {
            q1 = findMedian(a, 0, count / 2 - 1);
            q3 = findMedian(a, count / 2 + 1, count - 1);
        }

        System.out.format("%.1f", q3 - q1);
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
