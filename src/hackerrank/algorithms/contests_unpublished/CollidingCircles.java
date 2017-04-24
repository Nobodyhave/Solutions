package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/colliding-circles
 */
public class CollidingCircles {
    private static long[] COMBINATIONS = new long[200000];

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final int k = in.nextInt();
        final long[] r = new long[n];
        for (int i = 0; i < n; i++) {
            r[i] = in.nextLong();
        }

        initCombinations();

        double area = 0;
        for (int i = 0; i < n; i++) {
            area += Math.pow(r[i], 2);
        }

        long sum = 0;
        double coef = 0;
        for (int i = 0; i < n; i++) {
            coef += 2 * r[i] * sum;
            sum += r[i];
        }

        for (long i = 0; i < k; i++) {
            double binom = ((long) n * (n - 1) / 2);
            area += coef / binom;

            double x = COMBINATIONS[n - 2];
            x /= binom;
            coef *= x;
            n--;
        }

        System.out.println(area * Math.PI);
    }

    private static void initCombinations() {
        COMBINATIONS[0] = 1;
        COMBINATIONS[1] = 2;
        for (int i = 2; i < 200000; i++) {
            COMBINATIONS[i] = COMBINATIONS[i - 1] + (long) i + 1L;
        }
    }
}
