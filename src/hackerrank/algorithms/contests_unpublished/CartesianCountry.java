package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 24/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack49/challenges/cartesian-country
 */
public class CartesianCountry {
    private static long getMaxBridges(long x1, long y1, long x2, long y2, long xC, long yC) {
        final long dx1 = Math.abs(xC - x1);
        final long dx2 = Math.abs(xC - x2);
        final long dy1 = Math.abs(yC - y1);
        final long dy2 = Math.abs(yC - y2);

        long result = 0;

        for (long i = 1; i <= Math.min(dx1, dx2); i++) {
            result += Math.min(dy1, dy2) * 2;
        }

        return result + Math.min(dx1, dx2) + Math.min(dy1, dy2);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final long x1 = in.nextLong();
        final long y1 = in.nextLong();
        final long x2 = in.nextLong();
        final long y2 = in.nextLong();
        final long xC = in.nextLong();
        final long yC = in.nextLong();

        System.out.println(getMaxBridges(x1, y1, x2, y2, xC, yC));
    }
}
