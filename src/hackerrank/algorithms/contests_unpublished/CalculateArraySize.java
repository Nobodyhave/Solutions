package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 24/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack49/challenges/calculate-array-size
 */
public class CalculateArraySize {
    private static int getArrayKb(int n, int[] d) {
        int result = 4;
        for (int i = 0; i < d.length; i++) {
            result *= d[i];
        }

        return result / 1024;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
        }

        System.out.println(getArrayKb(n, d));
    }
}
