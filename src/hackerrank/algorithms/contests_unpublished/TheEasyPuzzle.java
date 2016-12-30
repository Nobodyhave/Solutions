package hackerrank.algorithms.contests_unpublished;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/sears-dots-arrows/challenges/the-easy-puzzle-1
 */
public class TheEasyPuzzle {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            boolean divisible = false;
            Set<Integer> used = new HashSet<>();
            BigInteger lcm = BigInteger.valueOf(in.nextInt());
            for (int i = 1; i < N; i++) {
                int next = in.nextInt();
                if (!divisible && !used.contains(next)) {
                    lcm = lcm(lcm, BigInteger.valueOf(next));
                    used.add(next);
                    if (lcm.mod(BigInteger.valueOf(K)).compareTo(BigInteger.ZERO) == 0) {
                        divisible = true;
                    }
                }

            }

            System.out.println(divisible ? "YES" : "NO");
        }
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) == 0) {
            return a;
        } else {
            return gcd(b, a.mod(b));
        }
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return b.multiply(a).divide(gcd(a, b));
    }
}
