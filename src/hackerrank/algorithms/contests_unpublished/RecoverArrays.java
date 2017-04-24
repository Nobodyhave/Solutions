package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-19/challenges/recover-the-array
 */
public class RecoverArrays {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] file = new int[n];
        for (int i = 0; i < n; i++) {
            file[i] = in.nextInt();
        }
        int i = 0;
        int count = 0;
        while (i < n) {
            i += file[i] + 1;
            count++;
        }

        System.out.println(count);
    }
}
