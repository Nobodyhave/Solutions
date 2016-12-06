package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 06/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/halloween-party
 */
public class HalloweenParty {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final long xCuts = N / 2;
            final long yCuts = N - N / 2;

            System.out.println(xCuts * yCuts);
        }
    }
}
