package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/non-divisible-subset
 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();

        final int[] remainders = new int[k];
        for (int i = 0; i < n; i++) {
            int ai = sc.nextInt();
            remainders[ai % k]++;
        }

        int result = 0;
        for (int i = 0; i * 2 <= k; i++) {
            final int opposite = (k - i) % k;
            if (i == opposite) {
                result += Math.min(remainders[i], 1);
            } else {
                result += Math.max(remainders[i], remainders[opposite]);
            }
        }
        System.out.println(result);

        sc.close();
    }
}
