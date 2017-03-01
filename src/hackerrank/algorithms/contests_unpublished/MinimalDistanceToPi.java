package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Aleksandr on 24/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w29/challenges/minimal-distance-to-pi
 */
public class MinimalDistanceToPi {
    private static final BigDecimal PI = new BigDecimal("3.14159265358979323846264338327950288419716939937510").setScale(50, BigDecimal.ROUND_HALF_DOWN);

    public static void main(String[] args) throws IOException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        long min = in.nextLong();
        long max = in.nextLong();
        getBestApproximation(min, max);
    }

    private static long getNumerator(BigDecimal denominator) {
        BigDecimal product = PI.multiply(denominator);
        BigDecimal low = product.setScale(0, BigDecimal.ROUND_FLOOR);
        BigDecimal high = product.setScale(0, BigDecimal.ROUND_CEILING);

        BigDecimal lowDist = low.divide(denominator, 50, BigDecimal.ROUND_HALF_DOWN).subtract(PI).abs();
        BigDecimal highDist = high.divide(denominator, 50, BigDecimal.ROUND_HALF_DOWN).subtract(PI).abs();

        if (lowDist.compareTo(highDist) <= 0) {
            return low.longValue();
        } else {
            return high.longValue();
        }
    }

    private static BigDecimal distToPi(BigDecimal denominator) {
        return (BigDecimal.valueOf(getNumerator(denominator)).divide(denominator, 50, BigDecimal.ROUND_HALF_DOWN)).subtract(PI).abs();
    }

    private static void getBestApproximation(long start, long end) {
        long cur = start;
        BigDecimal minDist = distToPi(BigDecimal.valueOf(cur));
        Collection<Long> steps = semiConvergentsDenominators(28);
        while (true) {
            for (Long step : steps) {
                if (cur + step > end) {
                    System.out.println(getNumerator(BigDecimal.valueOf(cur)) + "/" + cur);
                    return;
                }
                BigDecimal dist = distToPi(BigDecimal.valueOf(cur + step));
                if (dist.compareTo(minDist) < 0) {
                    minDist = dist;
                    cur += step;
                    break;
                }
            }
        }
    }

    private static Collection<Long> semiConvergentsDenominators(int scale) {
        final long[] a = convertToCommonFraction(PI, scale);
        final long[] h = new long[scale + 2];
        final long[] k = new long[scale + 2];

        h[0] = 0;
        h[1] = 1;
        k[0] = 1;
        k[1] = 0;

        Set<Long> distances = new TreeSet<>();
        for (int i = 2; i < scale + 2; i++) {
            h[i] = a[i - 2] * h[i - 1] + h[i - 2];
            k[i] = a[i - 2] * k[i - 1] + k[i - 2];
        }

        for (int i = 1; i < h.length - 1; i++) {
            for (int m = 0; m < a[i - 1]; m++) {
                distances.add(k[i - 1] + m * k[i]);
            }
        }

        return distances;
    }

    private static long[] convertToCommonFraction(BigDecimal rational, int scale) {
        final long[] a = new long[scale];
        BigDecimal value = rational;

        for (int i = 0; i < scale; i++) {
            long intPart = value.longValue();
            a[i] = intPart;
            BigDecimal leftover = value.subtract(BigDecimal.valueOf(intPart));
            value = BigDecimal.ONE.divide(leftover, 50, BigDecimal.ROUND_HALF_DOWN);
        }

        return a;
    }
}

