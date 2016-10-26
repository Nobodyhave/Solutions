package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-normal-distribution-1
 */


public class NormalDistributionI {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        final int mean = in.nextInt();
        final int sd = in.nextInt();

        final double x1 = in.nextDouble();
        final double x2 = in.nextDouble();
        final double x3 = in.nextDouble();

        double z = (x1 - mean) / (sd * Math.sqrt(2));
        final double f1 = (1 / 2.0) * (1.0 + Integral.integrate(0, z, 1000));
        System.out.format("%.3f\n", f1);
        z = (x2 - mean) / (sd * Math.sqrt(2));
        final double f2 = (1 / 2.0) * (1.0 + Integral.integrate(0, z, 1000));
        z = (x3 - mean) / (sd * Math.sqrt(2));
        final double f3 = (1 / 2.0) * (1.0 + Integral.integrate(0, z, 1000));
        System.out.format("%.3f\n", f3 - f2);
    }

    private static class Integral {
        private static double f(double x) {
            return 2 * Math.pow(Math.E, -Math.pow(x, 2)) / Math.sqrt(Math.PI);
        }

        static double integrate(double a, double b, int N) {
            final double h = (b - a) / N;
            double sum = 0.5 * (f(a) + f(b));
            for (int i = 1; i < N; i++) {
                double x = a + h * i;
                sum = sum + f(x);
            }

            return sum * h;
        }
    }
}
