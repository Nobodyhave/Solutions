package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 18/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack45/challenges/the-chosen-one
 */
public class TheChosenOne {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        if (n == 1) {
            System.out.println(a[0] + 1);
        }

        long[][] gcd = new long[2][n + 1];
        for (int i = 0; i < n; i++) {
            gcd[0][i + 1] = gcd(a[i], gcd[0][i]);
        }
        reverseArray(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            gcd[1][i + 1] = gcd(a[i], gcd[1][i]);
        }
        reverseArray(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            long gcdE = gcd(gcd[0][i], gcd[1][n - i - 1]);

            if (a[i] % gcdE != 0) {
                System.out.println(gcdE);
                break;
            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static void reverseArray(long[] a, int left, int right) {
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }

    private static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
