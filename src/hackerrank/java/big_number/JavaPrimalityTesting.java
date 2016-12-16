package hackerrank.java.big_number;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-primality-test
 */
public class JavaPrimalityTesting {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final BigInteger n = in.nextBigInteger();
        in.close();

        if (n.isProbablePrime(6)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
