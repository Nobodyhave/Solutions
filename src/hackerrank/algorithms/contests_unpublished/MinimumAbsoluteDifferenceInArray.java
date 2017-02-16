package hackerrank.algorithms.contests_unpublished;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/rookierank-2/challenges/minimum-absolute-difference-in-an-array
 */
public class MinimumAbsoluteDifferenceInArray {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);
        int minDiff = a[1] - a[0];
        for (int i = 2; i < n; i++) {
            if (a[i] - a[i - 1] < minDiff) {
                minDiff = a[i] - a[i - 1];
            }
        }

        System.out.println(minDiff);
    }
}
