package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/possible-path
 */
public class PossiblePath {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final long a = in.nextLong();
            final long b = in.nextLong();
            final long x = in.nextLong();
            final long y = in.nextLong();

            if (gcd(a, b) == gcd(x, y)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
