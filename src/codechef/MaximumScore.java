package codechef;

import java.util.Scanner;

/**
 * Created by Aleksandr on 05/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/MAXSC
 */
public class MaximumScore {
    public static void main(String[] args) throws java.lang.Exception {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[][] A = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = in.nextInt();
                }
            }

            int prevMax = Integer.MAX_VALUE;
            long sum = 0;
            for (int i = N - 1; i >= 0; i--) {
                int curMax = Integer.MIN_VALUE;
                for (int j = 0; j < N; j++) {
                    if (A[i][j] < prevMax && A[i][j] > curMax) {
                        curMax = A[i][j];
                    }
                }

                if (curMax != Integer.MIN_VALUE) {
                    sum += curMax;
                    prevMax = curMax;
                } else {
                    sum = -1;
                    break;
                }
            }

            System.out.println(sum);
        }
    }
}
