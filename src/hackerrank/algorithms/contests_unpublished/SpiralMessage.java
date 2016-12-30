package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/spiral-message
 */
public class SpiralMessage {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        char[][] a = new char[n][m];

        if (n == 0 || m == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i, k = 0, l = 0;

        /*  k - starting row index
            m - ending row index
            l - starting column index
            n - ending column index
            i - iterator
        */

        while (k < n && l < m) {
            /* Print the first column from the remaining columns */
            if (l < m) {
                for (i = n - 1; i >= k; --i) {
                    sb.append(a[i][l]);
                }
                l++;
            }

            /* Print the first row from the remaining rows */
            for (i = l; i < m; ++i) {
                sb.append(a[k][i]);
            }
            k++;

            /* Print the last column from the remaining columns */
            if (l < m) {
                for (i = k; i < n; ++i) {
                    sb.append(a[i][m - 1]);
                }
                m--;
            }

            /* Print the last row from the remaining rows */
            if (k < n) {
                for (i = m - 1; i >= l; --i) {
                    sb.append(a[n - 1][i]);
                }
                n--;
            }


        }

        String str = sb.toString();
        //System.out.println(str);
        String[] split = str.split("#+");
        int count = split.length;
        for (String s : split) {
            if (s.isEmpty()) {
                count--;
            }
        }
        System.out.println(count);
    }
}
