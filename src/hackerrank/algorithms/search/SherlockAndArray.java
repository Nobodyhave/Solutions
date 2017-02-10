package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class SherlockAndArray {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] a = new int[N];
            final int[] sum = new int[N];
            sum[0] = 0;
            a[0] = in.nextInt();
            for (int i = 1; i < N; i++) {
                a[i] = in.nextInt();
                sum[i] = sum[i - 1] + a[i - 1];
            }
            int sumR = 0;
            boolean isFound = false;
            for (int i = N - 1; i >= 0; i--) {
                if (sum[i] == sumR) {
                    System.out.println("YES");
                    isFound = true;
                    break;
                }
                sumR += a[i];
            }
            if (!isFound) {
                System.out.println("NO");
            }
        }
    }
}
