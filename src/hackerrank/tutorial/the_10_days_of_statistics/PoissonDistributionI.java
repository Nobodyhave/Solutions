package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-poisson-distribution-1
 */

import java.util.Scanner;

public class PoissonDistributionI {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final double X = in.nextDouble();
        final int targetX = in.nextInt();

        System.out.format("%.3f", Math.pow(X, targetX) * Math.pow(Math.E, -X) / fact(targetX));
    }

    private static int fact(int n) {
        int result = 1;
        while (n > 1) {
            result *= n--;
        }

        return result;
    }
}
