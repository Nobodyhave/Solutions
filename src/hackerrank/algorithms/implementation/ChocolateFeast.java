package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/chocolate-feast
 */
public class ChocolateFeast {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int n = in.nextInt();
            final int c = in.nextInt();
            final int m = in.nextInt();

            int chocolates = n / c;
            int wrappers = chocolates;

            while (wrappers >= m) {
                chocolates += wrappers / m;
                wrappers = wrappers % m + wrappers / m;
            }

            System.out.println(chocolates);
        }
    }
}
