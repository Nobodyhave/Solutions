package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-bitwise-and
 */

import java.util.Scanner;

public class BitwiseAnd {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            int max = Integer.MIN_VALUE;
            outer:
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int local = i & j;
                    if (local == K - 1) {
                        max = K - 1;
                        break outer;
                    } else if (local < K && local > max) {
                        max = local;
                    }
                }
            }

            System.out.println(max);
        }
    }
}
