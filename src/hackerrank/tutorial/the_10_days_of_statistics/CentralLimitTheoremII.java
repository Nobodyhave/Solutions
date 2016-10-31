package hackerrank.tutorial.the_10_days_of_statistics;

/**
 * Created by Aleksandr on 26/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-2
 */

import java.util.Scanner;

public class CentralLimitTheoremII {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final double tickets = in.nextDouble();
        final double students = in.nextDouble();
        final double mean = in.nextDouble();
        final double sd = in.nextDouble();

        final double newMean = students * mean;
        final double newSd = Math.sqrt(students) * sd;

        double z = (tickets - newMean) / (newSd * Math.sqrt(2));
        final double f = (1 / 2.0) * (1.0 + Integral.integrate(0, z, 1000));
        System.out.format("%.4f\n", f);
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
