package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 09/03/2017.
 * Project Solutions
 */
public class SuperSixSubstrings {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        char[] s = in.next().toCharArray();

        final long[][] dp = new long[100002][5];
        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }
        long result = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                result++;
            } else {
                result += f(dp, i, 0, s);
            }
        }

        System.out.println(result);
    }

    private static long f(long[][] dp, int i, int m, char[] s) {
        if (i == s.length) {
            return 0;
        }

        if (dp[i][m] != -1) {
            return dp[i][m];
        }
        int x = s[i] - '0';
        long result = f(dp, i + 1, (m + x) % 3, s) + (((x + m) % 3 == 0 && x % 2 == 0) ? 1 : 0);
        dp[i][m] = result;

        return result;
    }
}
