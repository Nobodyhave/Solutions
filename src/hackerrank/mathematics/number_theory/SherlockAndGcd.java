package hackerrank.mathematics.number_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-gcd
 */
public class SherlockAndGcd {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            int gcd = in.nextInt();
            for (int i = 1; i < N; i++) {
                gcd = gcd(gcd, in.nextInt());
            }

            if (gcd == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
