package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/dance-class
 */
public class DancingInPairs {
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final long N = in.nextLong();

            System.out.println(calculateDays(N));
        }
    }

    private static String calculateDays(long N) {
        if (N < 4) {
            return "odd";
        }

        long maxSqrt = (long) sqrt(BigInteger.valueOf(N)).longValue();
        long maxSquare = maxSqrt * maxSqrt;

        long count = maxSqrt - 1;

        if (maxSquare == N && maxSquare % 2 == 0) {
            return "even";
        } else if (maxSquare == N && maxSquare % 2 != 0) {
            return "odd";
        } else if (count % 2 != 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    private static BigInteger sqrt(BigInteger N) {
        if (N.signum() >= 0) {
            final int bitLength = N.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(N, root)) {
                root = root.add(N.divide(root)).divide(TWO);
            }
            return root;
        } else {
            throw new ArithmeticException("square root of negative number");
        }
    }

    private static boolean isSqrt(BigInteger n, BigInteger root) {
        final BigInteger lowerBound = root.pow(2);
        final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);

        return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
    }
}
