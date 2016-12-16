package hackerrank.mathematics.geometry;

import java.util.Scanner;

/**
 * Created by Aleksandr on 13/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/rectangular-game
 */
public class RectangularGame {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        for (int n = 0; n < N; n++) {
            final int a = in.nextInt();
            final int b = in.nextInt();

            if (a < minA) {
                minA = a;
            }
            if (b < minB) {
                minB = b;
            }
        }

        System.out.println((long) Math.max(1, minA) * Math.max(1, minB));
    }
}
