package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 14/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 */

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int i = in.nextInt();
        final int j = in.nextInt();
        final int k = in.nextInt();

        int count = 0;
        for (int l = i; l <= j; l++) {
            if (Math.abs((l - reverse(l))) % k == 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int reverse(int i) {
        final StringBuilder sb = new StringBuilder(String.valueOf(i));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
