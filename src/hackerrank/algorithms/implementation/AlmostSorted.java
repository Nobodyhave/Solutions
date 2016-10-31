package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 26/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/almost-sorted
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlmostSorted {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int firstInversion = -1, lastInversion = -1;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                firstInversion = i;
                break;
            }
        }

        if (firstInversion == -1) {
            System.out.println("yes");
            return;
        }

        for (int i = n - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                lastInversion = i;
                break;
            }
        }

        if (n == 2) {
            System.out.println("yes");
            System.out.format("swap %d %d", 1, 2);

        } else {
            swap(a, firstInversion, lastInversion);

            if (isSorted(a, firstInversion, lastInversion) && a[lastInversion] < a[lastInversion + 1] && a[firstInversion] > a[firstInversion - 1]) {
                System.out.println("yes");
                System.out.format("swap %d %d", firstInversion + 1, lastInversion + 1);
                return;
            }

            reverse(a, firstInversion + 1, lastInversion - 1);

            if (isSorted(a, firstInversion, lastInversion) && a[lastInversion] < a[lastInversion + 1] && a[firstInversion] > a[firstInversion - 1]) {
                System.out.println("yes");
                System.out.format("reverse %d %d", firstInversion + 1, lastInversion + 1);
            } else {
                System.out.println("no");
            }
        }

    }

    private static void swap(int[] a, int l, int r) {
        final int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            final int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    private static boolean isSorted(int[] a, int l, int r) {
        for (int i = l; i < r; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
