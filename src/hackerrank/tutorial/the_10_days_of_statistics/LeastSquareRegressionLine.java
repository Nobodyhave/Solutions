package hackerrank.tutorial.the_10_days_of_statistics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-least-square-regression-line
 */
public class LeastSquareRegressionLine {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int n = in.nextInt();
        final int[] x = new int[n];
        final int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }

        final double meanX = mean(x);
        final double sumX = sum(x);
        final double sumXofSquares = sumOfSquares(x);
        final double meanY = mean(y);
        final double sumY = sum(y);
        final double sumXY = sumOfProduct(x, y);

        final double b = (n * sumXY - sumX * sumY) / (n * sumXofSquares - Math.pow(sumX, 2));
        final double a = meanY - b * meanX;

        System.out.format("%.3f", a + b * 10);
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
