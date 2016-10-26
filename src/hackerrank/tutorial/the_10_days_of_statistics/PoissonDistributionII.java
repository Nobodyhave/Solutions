package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-poisson-distribution-2
 */

import java.util.Scanner;

public class PoissonDistributionII {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final double aL = in.nextDouble();
        final double bL = in.nextDouble();

        System.out.format("%.3f\n", 160 + 40 * (aL + Math.pow(aL, 2)));
        System.out.format("%.3f", 128 + 40 * (bL + Math.pow(bL, 2)));
    }
}
