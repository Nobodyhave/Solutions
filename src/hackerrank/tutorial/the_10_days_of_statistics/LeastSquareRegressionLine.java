package hackerrank.tutorial.the_10_days_of_statistics;

import java.util.stream.IntStream;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-least-square-regression-line
 */
public class LeastSquareRegressionLine {

    public static void main(String[] args) {
        final int n = 5;
        final int[] x = new int[]{95, 85, 80, 70, 60};
        final int[] y = new int[]{85, 95, 70, 65, 70};

        final double meanX = mean(x);
        final double sumX = sum(x);
        final double sumXofSquares = sumOfSquares(x);
        final double meanY = mean(y);
        final double sumY = sum(y);
        final double sumXY = sumOfProduct(x, y);

        final double b = (n * sumXY - sumX * sumY) / (n * sumXofSquares - Math.pow(sumX, 2));
        final double a = meanY - b * meanX;

        System.out.format("%.3f", a + b * 80);
    }

    private static double sum(int[] arr) {
        return IntStream.of(arr).sum();
    }

    private static double sumOfSquares(int[] arr) {
        return IntStream.of(arr).mapToDouble(operand -> Math.pow(operand, 2)).sum();
    }

    private static double sumOfProduct(int[] arr1, int[] arr2) {
        return IntStream.range(0, arr1.length).mapToDouble(i -> arr1[i] * arr2[i]).sum();
    }

    private static double mean(int[] arr) {
        return IntStream.of(arr).average().getAsDouble();
    }
}
