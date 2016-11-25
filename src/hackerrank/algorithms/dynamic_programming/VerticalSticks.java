package hackerrank.algorithms.dynamic_programming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/vertical-sticks
 */
public class VerticalSticks {
    private static BigInteger[] FACTORIALS = factorials(1000);

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] Y = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                Y[i] = in.nextInt();
            }

            System.out.format("%.2f\n", calculateResult(Y));
        }
    }

    private static double calculateResult(int[] a) {
        if (a.length == 2) {
            return 1.0;
        }

        Arrays.sort(a);

        final int N = a.length - 1;
        final int[] lessThen = new int[a.length];
        final int[] moreThen = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            if (i == 1) {
                lessThen[i] = 0;
            } else if (a[i] > a[i - 1]) {
                lessThen[i] = i - 1;
            } else {
                lessThen[i] = lessThen[i - 1];
            }
        }

        for (int i = 1; i < a.length; i++) {
            if (i == 1) {
                moreThen[i] = N - 1;
            } else if (a[i] > a[i - 1]) {
                moreThen[i] = N - i;
            } else {
                moreThen[i] = moreThen[i - 1];
            }
        }

        //System.out.println("Array: " + Arrays.toString(a));
        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i < a.length; i++) {
            for (int j = a.length - 1; j > 0; j--) {
                // If not enough smaller or equal numbers to fill space before element
                if (lessThen[i] < j - 1) {
                    //System.out.format("For element %d and length %d exist %d combinations\n", i, j, 0);
                    continue;
                }

                /* Multiply:
                1. Desired length - j
                2. Number of possible permutation before element - j-1
                3. Number of possible permutations with greater element or start before our run
                4. Number of all other possible permutations
                */
                final BigInteger traceLength = BigInteger.valueOf(j);
                final BigInteger smallerArrangements = arrangements(lessThen[i], j - 1);
                BigInteger othersForStart;
                BigInteger greaterBorderArrangements;
                BigInteger othersForRest;
                BigInteger shifts;

                BigInteger combinations;
                if (j != N) {
                    othersForStart = FACTORIALS[N - j];
                    greaterBorderArrangements = arrangements(moreThen[i], 1);
                    othersForRest = FACTORIALS[N - j - 1];
                    shifts = BigInteger.valueOf(N - j);
                } else {
                    othersForStart = BigInteger.ONE;
                    greaterBorderArrangements = BigInteger.ONE;
                    othersForRest = BigInteger.ONE;
                    shifts = BigInteger.ONE;
                }

                if (moreThen[i] == 0) {
                    greaterBorderArrangements = BigInteger.ZERO;
                    shifts = BigInteger.ONE;
                }
                combinations = smallerArrangements.multiply(othersForStart.add(greaterBorderArrangements.multiply(shifts).multiply(othersForRest)));
                result = result.add(traceLength.multiply(combinations));
                //System.out.format("For element %d and length %d exist %d combinations\n", i, j, combinations);
            }
        }

        return new BigDecimal(result).divide(new BigDecimal(FACTORIALS[N]), 2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    private static BigInteger arrangements(int n, int k) {
        if (k < 0 || k > n) {
            return BigInteger.ONE;
        }

        return FACTORIALS[n].divide(FACTORIALS[n - k]);
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
