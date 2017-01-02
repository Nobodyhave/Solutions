package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/nimble-game-1
 */
public class NimbleGame {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int G = in.nextInt();
        for (int g = 0; g < G; g++) {
            final int N = in.nextInt();
            final int[] a = new int[N];

            int xor = 0;
            for (int i = 0; i < N; i++) {
                if (in.nextInt() % 2 != 0) {
                    xor ^= i;
                }
            }

            if (xor != 0) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
    }
}
