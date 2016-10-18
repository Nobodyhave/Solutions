package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class ManasaAndStones {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int n = in.nextInt();
            final int a = in.nextInt();
            final int b = in.nextInt();

            if (a != b) {
                for (int i = 0; i < n; i++) {
                    System.out.print((Math.min(a, b) * (n - 1) + i * Math.abs(a - b) + " "));
                }
            } else {
                System.out.print(Math.min(a, b) * (n - 1));
            }
            System.out.println();
        }
    }
}
