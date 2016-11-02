package hackerrank.artificial_intelligence.statistics_and_machine_learning;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/stat-warmup
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class BasicStatisticsWarmup {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextDouble();
        }

        final double mean = mean(a);
        final double sd = standardDeviation(a, mean);
        final double median = median(a);
        final double mode = mode(a);
        final double sE = standardError(1.96, N, sd);

        System.out.format("%.1f\n", mean);
        System.out.format("%.1f\n", median);
        System.out.format("%d\n", (int) mode);
        System.out.format("%.1f\n", sd);
        System.out.format("%.1f\n", mean - sE);
        System.out.format("%.1f", mean + sE);
    }

    private static double mean(double[] arr) {
        return DoubleStream.of(arr).average().getAsDouble();
    }

    private static double standardDeviation(double[] arr, double mean) {
        return Math.sqrt(DoubleStream.of(arr)
                .map(operand -> Math.pow(operand - mean, 2))
                .average()
                .getAsDouble());
    }

    private static double median(double[] arr) {
        Arrays.sort(arr);

        final int N = arr.length;
        double median;
        if (N % 2 == 0) {
            median = (arr[N / 2 - 1] + arr[N / 2]) / 2.0;
        } else {
            median = arr[N / 2];
        }

        return median;
    }

    private static double mode(double[] arr) {
        Arrays.sort(arr);

        final int N = arr.length;
        int modCount = 1;
        int maxCount = modCount;
        double modVal = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
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

        return modVal;
    }

    private static double standardError(double Z, int N, double sd) {
        return Z * sd / Math.sqrt(N);
    }
}
