package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/harry-potter-and-the-floating-rocks
 */
public class SumarAndFloatingRocks {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int x1 = in.nextInt();
            final int y1 = in.nextInt();
            final int x2 = in.nextInt();
            final int y2 = in.nextInt();

            int result;
            if (x1 == x2) {
                result = Math.abs(y1 - y2) - 1;
            } else if (y1 == y2) {
                result = Math.abs(x1 - x2) - 1;
            } else {
                result = gcd(Math.abs(y2 - y1), Math.abs(x2 - x1)) - 1;
            }

            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
