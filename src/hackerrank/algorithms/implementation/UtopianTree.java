package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/domains/algorithms/implementation
 */

import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();

            if (n == 0) {
                System.out.println(1);
                continue;
            }

            int height = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    height *= 2;
                } else {
                    height += 1;
                }
            }
            System.out.println(height);
        }
    }
}

