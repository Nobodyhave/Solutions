package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w27/challenges
 */
public class DrawingBook {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int p = in.nextInt();

        if (p == 1 || p == n) {
            System.out.println(0);
        } else if (n % 2 == 0) {
            if (p <= n / 2) {
                System.out.println(p / 2);
            } else {
                System.out.println((n + 1 - p) / 2);
            }
        } else {
            if (p <= n / 2) {
                System.out.println(p / 2);
            } else {
                System.out.println((n - p) / 2);
            }
        }
    }
}
