package hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/extra-long-factorials
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        BigInteger big = BigInteger.valueOf(N);

        for (int i = N - 1; i > 0; i--) {
            big = big.multiply(BigInteger.valueOf(i));
        }

        System.out.println(big.toString());
    }
}
