package hackerrank.algorithms.warmup;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/compare-the-triplets
 */

import java.util.Scanner;

public class CompareTheTriplets {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int a0 = in.nextInt();
        final int a1 = in.nextInt();
        final int a2 = in.nextInt();
        final int b0 = in.nextInt();
        final int b1 = in.nextInt();
        final int b2 = in.nextInt();
        in.close();

        int sum1 = 0, sum2 = 0;

        if (a0 > b0) {
            sum1++;
        } else if (a0 < b0) {
            sum2++;
        }

        if (a1 > b1) {
            sum1++;
        } else if (a1 < b1) {
            sum2++;
        }

        if (a2 > b2) {
            sum1++;
        } else if (a2 < b2) {
            sum2++;
        }

        System.out.println(sum1 + " " + sum2);
    }
}

