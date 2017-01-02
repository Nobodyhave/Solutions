package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/save-the-prisoner
 */
public class SaveThePrisoner {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int M = in.nextInt();
            final int S = in.nextInt();

            final int result = (S + M) % (N) - 1;
            if (result != 0) {
                System.out.println((S + M) % (N) - 1);
            } else {
                System.out.println(N);
            }
        }
    }
}
