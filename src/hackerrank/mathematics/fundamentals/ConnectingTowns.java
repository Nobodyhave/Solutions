package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 05/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/connecting-towns
 */
public class ConnectingTowns {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            long result = 1;
            for (int i = 0; i < N - 1; i++) {
                result = result * in.nextInt() % 1234567;
            }

            System.out.println(result);
        }
    }
}
