package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/07/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-22/challenges/parity-game
 */
public class ParityGame {
    private static int smallestSizeSubsequence(int n, int[] A) {
        if (A == null || n == 0 || (n == 1 && A[0] % 2 != 0)) {
            return -1;
        }

        int sum = 0;
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                evenCount++;
            }
            sum += A[i];
        }

        if (sum % 2 == 0) {
            return 0;
        } else if (n - evenCount != 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        System.out.println(smallestSizeSubsequence(n, A));
    }
}
