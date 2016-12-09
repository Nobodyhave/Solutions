package hackerrank.mathematics.number_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 09/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/eulers-criterion
 */
public class EulersCriterion {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int A = in.nextInt();
            final int M = in.nextInt();

            long result = exponentiate(A, (M - 1) / 2, M);

            if (result == 0 || result == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static long exponentiate(long x, long exp, int mod) {
        if (mod == 1) {
            return 0;
        }

        long result = 1;
        long base = x % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }

        return result;
    }
}
