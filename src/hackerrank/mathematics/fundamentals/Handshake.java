package hackerrank.mathematics.fundamentals;

/**
 * Created by Aleksandr on 01/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/handshake
 */

import java.util.Scanner;

public class Handshake {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final long result = (long) N * (N - 1) / 2;

            System.out.println(result);
        }
    }
}

