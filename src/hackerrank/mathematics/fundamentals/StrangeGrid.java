package hackerrank.mathematics.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/strange-grid
 */
public class StrangeGrid {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int r = in.nextInt();
        final int c = in.nextInt();

        BigInteger result = BigInteger.ZERO;
        if (r % 2 != 0) {
            result = result.add(BigInteger.valueOf((c - 1) * 2));
        } else {
            result = result.add(BigInteger.valueOf((c - 1) * 2 + 1));
        }

        result = result.add(BigInteger.valueOf(r - 1).divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(10)));

        System.out.println(result);
    }
}
