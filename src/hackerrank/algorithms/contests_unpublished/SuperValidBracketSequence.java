package hackerrank.algorithms.contests_unpublished;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/super-valid-bracket-sequences
 */
public class SuperValidBracketSequence {
    private static BigInteger[] FACTORIALS = factorials(400);
    private static BigInteger[] CATALANS = catalans(200);
    private static BigInteger[][] NARAYANA = narayana(200);

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int n = in.nextInt();
            final int k = in.nextInt();

            BigInteger result = CATALANS[n / 2];
            if (k != 0) {
                BigInteger[] nums = NARAYANA[n / 2];
                for (int i = 1; i <= k; i++) {
                    if (i % 2 == 0) {
                        result = result.subtract(nums[i / 2]);
                    }
                }
            }

            System.out.println(result.mod(BigInteger.valueOf(1000000007)));
        }
    }

    private static BigInteger[][] narayana(int n) {
        final BigInteger[][] nums = new BigInteger[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i][j] = combination(i, j).multiply(combination(i, j - 1)).divide(BigInteger.valueOf(i));
            }
        }

        return nums;
    }

    private static BigInteger[] catalans(int n) {
        final BigInteger[] nums = new BigInteger[n + 1];
        nums[0] = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            nums[i] = combination(2 * i, i).divide(BigInteger.valueOf(i + 1));
        }

        return nums;
    }

    private static BigInteger combination(int n, int k) {
        return FACTORIALS[n].divide(FACTORIALS[n - k]).divide(FACTORIALS[k]);
    }

    private static BigInteger[] factorials(int n) {
        final BigInteger[] nums = new BigInteger[n + 1];
        nums[0] = BigInteger.ONE;
        nums[1] = BigInteger.ONE;

        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            nums[i] = fact;
        }

        return nums;
    }
}
