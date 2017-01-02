package hackerrank.algorithms.game_theory;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/nim-game-1
 */
public class IntroductionToNimGame {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int G = in.nextInt();
        for (int g = 0; g < G; g++) {
            final int n = in.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();

                count = count ^ s;
            }

            if (count == 0) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}
