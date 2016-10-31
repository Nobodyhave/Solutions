package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 27/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-spearman-rank-correlation-coefficient
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpearmanRankCorrelation {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();

        final double[] X = new double[n];
        final double[] Xs = new double[n];
        for (int i = 0; i < n; i++) {
            X[i] = in.nextDouble();
            Xs[i] = X[i];
        }

        final double[] Y = new double[n];
        final double[] Ys = new double[n];
        for (int i = 0; i < n; i++) {
            Y[i] = in.nextDouble();
            Ys[i] = Y[i];
        }

        final Map<Double, Integer> rankX = new HashMap<>();
        Arrays.sort(Xs);
        for (int i = 0; i < n; i++) {
            rankX.put(Xs[i], i + 1);
        }

        final Map<Double, Integer> rankY = new HashMap<>();
        Arrays.sort(Ys);
        for (int i = 0; i < n; i++) {
            rankY.put(Ys[i], i + 1);
        }

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += Math.pow(rankX.get(X[i]) - rankY.get(Y[i]), 2);
        }

        final double src = 1 - 6 * sumD / (n * (Math.pow(n, 2) - 1));

        System.out.format("%.3f", src);
    }
}
