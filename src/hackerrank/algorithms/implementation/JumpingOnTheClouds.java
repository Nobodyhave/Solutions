package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        final int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = c[1] == 1 ? Integer.MAX_VALUE : 1;
        for (int i = 2; i < n; i++) {
            if (c[i] == 1) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + 1;
            }
        }
        System.out.println(dp[n - 1]);
    }
}
