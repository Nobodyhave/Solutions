package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-geometric-distribution-1
 */

import java.util.Scanner;

public class GeometricDistributionI {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int defectN = in.nextInt();
        final int defectD = in.nextInt();
        final int N = in.nextInt();
        final double defectRate = (double) defectN / defectD;

        System.out.format("%.3f", Math.pow(1 - defectRate, 4) * defectRate);
    }
}
