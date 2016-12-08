package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/is-fibo
 */
public class IsFibo {
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final long N = in.nextLong();

            final BigInteger r1 = BigInteger.valueOf(5).multiply(BigInteger.valueOf(N).pow(2)).add(BigInteger.valueOf(4));
            final BigInteger r2 = BigInteger.valueOf(5).multiply(BigInteger.valueOf(N).pow(2)).subtract(BigInteger.valueOf(4));

            if (sqrt(r1).pow(2).compareTo(r1) == 0 || sqrt(r2).pow(2).compareTo(r2) == 0) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }
    }

    private static BigInteger sqrt(BigInteger n) {
        if (n.signum() >= 0) {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root)) {
                root = root.add(n.divide(root)).divide(TWO);
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
