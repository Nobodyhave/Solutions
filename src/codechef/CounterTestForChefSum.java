package codechef;

import java.util.Scanner;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/OCT17/problems/CHEFCOUN
 */
public class CounterTestForChefSum {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            int count = 42950;
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (i < count || i > N - count - 1) {
                    sb.append(99999).append(" ");
                } else {
                    sb.append(1).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
