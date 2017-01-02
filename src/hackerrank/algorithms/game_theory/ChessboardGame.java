package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/a-chessboard-game-1
 */
public class ChessboardGame {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int x = in.nextInt();
            final int y = in.nextInt();

            if ((x % 4 == 1 || x % 4 == 2) && (y % 4 == 1 || y % 4 == 2)) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }

        }
    }
}
