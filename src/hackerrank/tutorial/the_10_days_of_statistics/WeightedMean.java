package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-weighted-mean
 */

import java.util.Scanner;

public class WeightedMean {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        final int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = in.nextInt();
        }

        double mean = 0.0;
        int weightSum = 0;
        for (int i = 0; i < N; i++) {
            mean += w[i] * arr[i];
            weightSum += w[i];
        }

        System.out.format("%.1f", mean / weightSum);
    }
}
