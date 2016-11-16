package hackerrank.algorithms.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 16/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/common-child
 */
public class CommonChild {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final String s1 = in.next();
        final String s2 = in.next();

        final int[][] dp = new int[s1.length() + 1][s1.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[dp.length - 1][dp.length - 1]);
    }
}
