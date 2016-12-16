package hackerrank.java.big_number;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-biginteger
 */
public class JavaBigInteger {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final BigInteger a = in.nextBigInteger();
        final BigInteger b = in.nextBigInteger();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
