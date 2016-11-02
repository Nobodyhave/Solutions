package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-basic-statistics
 */

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianMode {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int sum = arr[N - 1];
        int modCount = 1;
        int maxCount = modCount;
        int modVal = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sum += arr[i];
            if (arr[i] == arr[i + 1]) {
                modCount++;
            } else {
                if (modCount >= maxCount) {
                    if (modCount > 1) {
                        modVal = arr[i + 1];
                    } else {
                        modVal = arr[i];
                    }
                    maxCount = modCount;
                }
                modCount = 1;
            }
        }

        final double mean = (double) sum / N;

        double median;
        if (N % 2 == 0) {
            median = (arr[N / 2 - 1] + arr[N / 2]) / 2.0;
        } else {
            median = arr[N / 2];
        }

        System.out.format("%.1f\n", mean);
        System.out.format("%.1f\n", median);
        System.out.println(modVal);
    }
}
