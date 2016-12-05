package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/restaurant
 */
public class Restaurant {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int K = in.nextInt();

            if (K > N / 2) {
                System.out.println(2 * (N - K - 1));
            } else if (K == N / 2) {
                System.out.println(N - 1);
            } else {
                System.out.println(2 * K + 1);
            }
        }
    }
}
