package hackerrank.artificial_intelligence.statistics_and_machine_learning;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/submissions/all
 */

import java.util.Scanner;
import java.util.stream.IntStream;

public class ComputingTheCorrelation {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] M = new int[N];
        final int[] P = new int[N];
        final int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            M[i] = in.nextInt();
            P[i] = in.nextInt();
            C[i] = in.nextInt();
        }

        System.out.format("%.2f\n", calculatePearsonProductMomentCorrelationCoefficient(M, P));
        System.out.format("%.2f\n", calculatePearsonProductMomentCorrelationCoefficient(P, C));
        System.out.format("%.2f\n", calculatePearsonProductMomentCorrelationCoefficient(C, M));
    }

    private static double calculatePearsonProductMomentCorrelationCoefficient(int[] x, int[] y) {
        final int n = x.length;

        final double sumX = sum(x);
        final double sumXofSquares = sumOfSquares(x);
        final double sumY = sum(y);
        final double sumYofSquares = sumOfSquares(y);
        final double sumXY = sumOfProduct(x, y);

        return (n * sumXY - sumX * sumY) / (Math.sqrt((n * sumXofSquares - Math.pow(sumX, 2))) * Math.sqrt((n * sumYofSquares - Math.pow(sumY, 2))));
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
}
