package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-1
 */

import java.util.Scanner;

public class BinomialDistributionI {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final double rBoys = in.nextDouble();
        final double rGirls = in.nextDouble();
        final double pBoys = rBoys / (rBoys + rGirls);
        final double pGirls = 1 - pBoys;

        double sum = 0;
        for (int i = 3; i <= 6; i++) {
            sum += (fact(6) / (fact(i) * fact(6 - i))) * Math.pow(pBoys, i) * Math.pow(pGirls, 6 - i);
        }

        System.out.format("%.3f", sum);
    }

    private static int fact(int n) {
        int result = 1;
        while (n > 1) {
            result *= n--;
        }

        return result;
    }
}
