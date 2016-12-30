package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/counting-mistakes
 */
public class CountingMistakes {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int count = (a[0] == 1 ? 0 : 1);

        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1] + 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
