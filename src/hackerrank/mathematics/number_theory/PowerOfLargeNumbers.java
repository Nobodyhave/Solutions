package hackerrank.mathematics.number_theory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 12/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/power-of-large-numbers
 */
public class PowerOfLargeNumbers {
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final BigInteger A = in.nextBigInteger();
            final BigInteger B = in.nextBigInteger();
            System.out.println(modPowByExponent(A, B, 1000000007));
        }
    }

    private static long modPowByExponent(BigInteger x, BigInteger exp, long mod) {
        if (mod == 0) {
            return 0;
        }

        long result = 1;
        long base = x.mod(BigInteger.valueOf(mod)).longValue();
        long expL = exp.mod(BigInteger.valueOf(mod - 1)).longValue();

        while (expL > 0) {
            if (expL % 2 == 1) {
                result = (result * base) % mod;
            }
            expL = expL >> 1;
            base = (base * base) % mod;
        }

        return result;
    }
}
