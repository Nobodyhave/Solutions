package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 27/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-pearson-correlation-coefficient
 */

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class PearsonCorrelationCoefficientI {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();

        final double[] X = new double[n];
        for (int i = 0; i < n; i++) {
            X[i] = in.nextDouble();
        }

        final double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            Y[i] = in.nextDouble();
        }

        final double meanX = mean(X);
        final double sdX = standardDeviation(X, meanX);
        final double meanY = mean(Y);
        final double sdY = standardDeviation(Y, meanY);

        double pcc = 0;

        for (int i = 0; i < n; i++) {
            pcc += (X[i] - meanX) * (Y[i] - meanY);
        }

        pcc /= n * sdX * sdY;

        System.out.format("%.3f", pcc);
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
}
