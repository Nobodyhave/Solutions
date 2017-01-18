package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/boat-trip
 */
public class BoatTrips {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int c = in.nextInt();
        final int m = in.nextInt();
        final int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        int mc = m * c;

        for (int i = 0; i < n; i++) {
            if (p[i] > mc) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
