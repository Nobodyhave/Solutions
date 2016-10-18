package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/taum-and-bday
 */

import java.util.Scanner;

public class TaumAndBirthday {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();

            long cost;
            if (x > y + z) {
                cost = w * y + b * (y + z);
            } else if (y > x + z) {
                cost = b * x + w * (x + z);
            } else {
                cost = b * x + w * y;
            }

            System.out.println(cost);
        }
    }
}

