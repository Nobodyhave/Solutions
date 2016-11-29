package hackerrank.algorithms.dynamic_programming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 29/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/coin-change
 */
public class CoinChange {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final int M = in.nextInt();

        final int[] coins = new int[M];
        for (int m = 0; m < M; m++) {
            coins[m] = in.nextInt();
        }

        final long[][] dp = new long[M + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}
