package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 25/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-coin-change
 */

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int coins[] = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = in.nextInt();
        }

        final long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                if (j == coins[i]) {
                    dp[j] += 1;
                } else {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[n]);
    }
}

