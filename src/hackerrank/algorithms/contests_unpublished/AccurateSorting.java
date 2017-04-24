package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 11/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w31/challenges/accurate-sorting
 */
public class AccurateSorting {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int n = in.nextInt();
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            boolean isSwapped = true;
            while (isSwapped) {
                isSwapped = false;
                for (int i = 1; i < n; i++) {
                    if (a[i - 1] - a[i] == 1) {
                        isSwapped = true;
                        swap(a, i, i - 1);
                    }
                }
            }

            if(isSorted(a)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static void swap(int[] a, int i, int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
