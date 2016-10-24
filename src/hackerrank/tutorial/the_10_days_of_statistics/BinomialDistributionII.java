package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-2
 */

import java.util.Scanner;

public class BinomialDistributionII {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int p = in.nextInt();
        final int n = in.nextInt();
        final double pGood = 1 - p / 100.0;
        final double pBad = p / 100.0;

        double sum = 0;
        for (int i = 0; i <= 2; i++) {
            sum += (fact(n) / (fact(i) * fact(n - i))) * Math.pow(pBad, i) * Math.pow(pGood, n - i);
        }

        System.out.format("%.3f\n", sum);

        sum = 0;
        for (int i = 2; i <= n; i++) {
            sum += (fact(n) / (fact(i) * fact(n - i))) * Math.pow(pBad, i) * Math.pow(pGood, n - i);
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
