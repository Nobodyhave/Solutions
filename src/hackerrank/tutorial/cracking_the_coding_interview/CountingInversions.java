package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 21/10/2016.
 * Project Solutions
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingInversions {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int n = in.nextInt();
            final int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            final long inversions = sort(arr);

            System.out.println(inversions);
        }
    }

    private static long sort(int[] a) {
        return sort(a, new int[a.length], 0, a.length - 1);
    }

    private static long sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) {
            return 0;
        }
        final int mid = lo + (hi - lo) / 2;
        final long left = sort(a, aux, lo, mid);
        final long right = sort(a, aux, mid + 1, hi);
        return left + right + merge(a, aux, lo, mid, hi);
    }

    private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        long count = 0;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                count += (mid - i) + 1;
            } else {
                a[k] = aux[i++];
            }
        }

        return count;
    }
}

