package hackerrank.mathematics.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-permutations
 */
public class SherlockAndPermutations {
    private static BigInteger[] FACTORIALS = factorials(2000);

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();

            final BigInteger result = multiSetPermutation(N, M - 1).mod(BigInteger.valueOf(1000000007));

            System.out.println(result);
        }
    }

    private static BigInteger multiSetPermutation(int... M) {
        final int n = IntStream.of(M).sum();

        BigInteger result = FACTORIALS[n];
        for (Integer m : M) {
            result = result.divide(FACTORIALS[m]);
        }

        return result;
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
