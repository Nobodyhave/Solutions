package hackerrank.algorithms.contests_unpublished;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/walmart-codesprint-algo/challenges/popsicle-stick-mountains
 */
public class PopsicleStickMountains {
    private static BigInteger[] FACTORIALS = factorials(4000);
    private static BigInteger[] CATALANS = catalans(2000);

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();

        final BigInteger MOD = BigInteger.valueOf(1000000007);
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            System.out.println(CATALANS[N / 2].mod(MOD));
        }
    }

    private static BigInteger[] catalans(int n) {
        final BigInteger[] nums = new BigInteger[n + 1];
        nums[0] = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1].add(FACTORIALS[2 * i].divide(BigInteger.valueOf(i + 1)).divide(FACTORIALS[i]).divide(FACTORIALS[i]));
        }

        return nums;
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
