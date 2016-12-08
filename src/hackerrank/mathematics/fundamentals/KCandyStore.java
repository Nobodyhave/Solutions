package hackerrank.mathematics.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/k-candy-store
 */
public class KCandyStore {
    private static BigInteger[] FACTORIALS = factorials(1000);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            final String result = combinations(N + K - 1, K).toString();
            if (result.length() > 9) {
                final StringBuilder sb = new StringBuilder(result.substring(result.length() - 9));
                while (sb.charAt(0) == '0') {
                    sb.deleteCharAt(0);
                }
                System.out.println(sb.toString());
            } else {
                System.out.println(result);
            }
        }
    }

    private static BigInteger combinations(int n, int k) {
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
