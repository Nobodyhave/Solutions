package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 */
public class SherlockAndSquares {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            final int min = scanner.nextInt();
            final int max = scanner.nextInt();

            int count = 0;
            for (int j = (int) Math.sqrt(min); j * j <= max; j++) {
                if (j * j >= min) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
