package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 26/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-3
 */

import java.util.Scanner;

public class CentralLimitTheoremIII {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final double samples = in.nextDouble();
        final double mean = in.nextDouble();
        final double sd = in.nextDouble();
        final double interval = in.nextDouble();
        final double z = in.nextDouble();

        final double newMean = samples * mean;
        final double newSd = Math.sqrt(samples) * sd;

        System.out.format("%.2f\n", (newMean - newSd * z) / samples);
        System.out.format("%.2f\n", (newMean + newSd * z) / samples);
    }
}
