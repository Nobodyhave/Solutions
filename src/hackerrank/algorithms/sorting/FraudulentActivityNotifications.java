package hackerrank.algorithms.sorting;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int d = in.nextInt();

        final int[] data = new int[n];
        final int[] counts = new int[201];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }

        for (int i = 0; i < d; i++) {
            counts[data[i]]++;
        }

        int count = 0;
        for (int start = 0, end = d; end < n; start++, end++) {
            final double median = calculateMedian(counts, d);
            final int spent = data[end];

            if (spent >= median * 2) {
                count++;
            }

            counts[data[start]]--;
            counts[spent]++;
        }

        System.out.println(count);
    }

    private static double calculateMedian(int[] counts, int d) {
        double median = 0;
        int sum = 0;
        if (d % 2 == 0) {
            boolean firstFound = false;
            for (int i = 0; i < counts.length; i++) {
                sum += counts[i];
                if (!firstFound && sum > d / 2 - 1) {
                    firstFound = true;
                    median = i;
                }
                if (sum > d / 2) {
                    median = (median + i) / 2.0;
                    break;
                }
            }
        } else {
            for (int i = 0; i < counts.length; i++) {
                sum += counts[i];
                if (sum > d / 2) {
                    median = i;
                    break;
                }
            }
        }

        return median;
    }
}
