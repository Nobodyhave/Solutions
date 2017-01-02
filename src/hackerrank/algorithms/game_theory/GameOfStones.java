package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/game-of-stones-1
 */
public class GameOfStones {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            if (N == 1 || N % 7 == 0 || N % 7 == 1) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}
