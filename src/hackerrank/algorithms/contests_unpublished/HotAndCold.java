package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 03/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-20/challenges/hot-and-cold
 */
public class HotAndCold {
    private static String isSatisfiable(int c1, int c2, int h1, int h2) {
        return Math.max(c1, c2) <= Math.min(h1, h2) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        // Return "YES" if all four conditions can be satisfied, and "NO" otherwise
        final int c1 = in.nextInt();
        final int c2 = in.nextInt();
        final int h1 = in.nextInt();
        final int h2 = in.nextInt();
        final String result = isSatisfiable(c1, c2, h1, h2);
        System.out.println(result);
    }
}
