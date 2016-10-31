package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/apple-and-orange
 */

import java.util.Scanner;

public class AppleAndOrange {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int t = in.nextInt();
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int m = in.nextInt();
        final int n = in.nextInt();
        int count = 0;
        for (int i = 0; i < m; i++) {
            final int d = in.nextInt();
            if (a + d >= s && a + d <= t) {
                count++;
            }
        }
        System.out.println(count);

        count = 0;
        for (int i = 0; i < n; i++) {
            final int d = in.nextInt();
            if (b + d >= s && b + d <= t) {
                count++;
            }
        }
        System.out.println(count);
    }
}

