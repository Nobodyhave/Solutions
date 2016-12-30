package hackerrank.algorithms.contests_unpublished;

/**
 * Created by Aleksandr on 18/11/2016.
 * Project Solutions
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimizingSummation {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        Arrays.sort(a);

        long[] ps = new long[n];
        ps[0] = a[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + a[i];
        }

        long min = calculateSum(a, 0, k - 1);
        long sum = min;

        for (int i = k; i < a.length; i++) {
            sum = sum
                    + (long) (2 * (k - 1) * (Math.pow(a[i], 2) - Math.pow(a[i - k], 2)))
                    + 4 * (a[i - k] - a[i]) * (ps[i - 1] - ps[i - k]);
            if (sum < min) {
                min = sum;
            }
        }

        System.out.println(min);
    }

    private static long calculateSum(int[] a, int left, int right) {
        long sum = 0;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                sum += 2 * Math.pow(a[i] - a[j], 2);
            }
        }

        return sum;
    }

}


