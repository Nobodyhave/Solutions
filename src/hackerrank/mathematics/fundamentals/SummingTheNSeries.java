package hackerrank.mathematics.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/summing-the-n-series
 */
public class SummingTheNSeries {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final long T = in.nextLong();
        for (int t = 0; t < T; t++) {
            final long N = in.nextLong();

            final BigInteger t1 = BigInteger.ONE;
            final BigInteger tN = BigInteger.valueOf(N).pow(2).subtract(BigInteger.valueOf(N).subtract(BigInteger.ONE).pow(2));

            System.out.println(sumOfArithmeticProgression(t1, tN, N).mod(BigInteger.valueOf(1000000007)));
        }
    }

    private static BigInteger sumOfArithmeticProgression(BigInteger start, BigInteger end, long length) {
        return BigInteger.valueOf(length).multiply(start.add(end)).divide(BigInteger.valueOf(2));
    }
}
