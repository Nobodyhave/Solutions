package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 24/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack48/challenges/tight-arrays
 */
public class TightArrays {
    private static int shortestTightArray(int a, int b, int c) {
        return Math.abs(b - a) + Math.abs(c - b) + 1;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        final int result = shortestTightArray(a, b, c);
        System.out.println(result);
    }
}
