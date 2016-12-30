package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w26/challenges/game-with-cells
 */
public class ArmyGame {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if (n == 0 || m == 0) {
            System.out.println(0);
        } else if (n == 1) {
            if (m % 2 != 0) {
                m++;
            }
            System.out.println(m / 2);
        } else if (m == 1) {
            if (n % 2 != 0) {
                n++;
            }
            System.out.println(n / 2);
        } else {
            if (m % 2 != 0) {
                m++;
            }
            if (n % 2 != 0) {
                n++;
            }
            System.out.println((n / 2) * (m / 2));
        }

    }
}
