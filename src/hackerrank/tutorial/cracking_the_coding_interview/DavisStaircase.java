package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase
 */

import java.util.Scanner;

public class DavisStaircase {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        for (int i = 0; i < s; i++) {
            final int n = in.nextInt();

            if (n == 1) {
                System.out.println(1);
                continue;
            } else if (n == 2) {
                System.out.println(2);
                continue;
            } else if (n == 3) {
                System.out.println(4);
                continue;
            }

            final int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j < dp.length; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }
    }
}

