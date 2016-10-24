package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-geometric-distribution-2
 */

import java.util.Scanner;

public class GeometricDistributionII {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int defectN = in.nextInt();
        final int defectD = in.nextInt();
        final int N = in.nextInt();
        final double defectRate = (double) defectN / defectD;

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.pow(1 - defectRate, i) * defectRate;
        }
        System.out.format("%.3f", sum);
    }
}
