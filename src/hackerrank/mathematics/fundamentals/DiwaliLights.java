package hackerrank.mathematics.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/diwali-lights
 */
public class DiwaliLights {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final BigInteger result = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);

            System.out.println(result.mod(BigInteger.valueOf(100000)));
        }
    }
}
