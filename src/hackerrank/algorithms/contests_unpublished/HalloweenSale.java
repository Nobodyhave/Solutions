package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 11/09/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-23/challenges/halloween-sale
 */
public class HalloweenSale {
    private static int howManyGames(int p, int d, int m, int s) {
        int count = 0;
        while (s - p >= 0) {
            if (p < m) {
                count += s / m;
                break;
            } else {
                count++;
                s -= p;
                p -= d;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int p = in.nextInt();
        final int d = in.nextInt();
        final int m = in.nextInt();
        final int s = in.nextInt();

        System.out.println(howManyGames(p, d, m, s));

        in.close();
    }
}
