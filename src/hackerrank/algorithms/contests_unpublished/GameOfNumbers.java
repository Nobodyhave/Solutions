package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/ncr-codesprint/challenges/game-of-numbers
 */
public class GameOfNumbers {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int G = in.nextInt();
        for (int g = 0; g < G; g++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int k = in.nextInt();

            if (r >= k) {
                System.out.println("Alice");
            } else {
                if (k % (r + l) > r || k % (r + l) == 0) {
                    System.out.println("Bob");
                } else {
                    System.out.println("Alice");
                }
            }
        }
    }
}
