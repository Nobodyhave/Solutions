package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w25/challenges/baby-step-giant-step
 */
public class BabyStepGiantStep {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int d = in.nextInt();

            if (d == 0) {
                System.out.println(0);
            } else if (d == a || d == b) {
                System.out.println(1);
            } else {
                final int max = Math.max(a, b);
                if (d % max == 0) {
                    System.out.println(d / max);
                } else if (d % max == Math.min(a, b)) {
                    System.out.println(d / max + 1);
                } else if (d < max) {
                    System.out.println(2);
                } else {
                    int div = (d / max) - 1;
                    int left = d - div * max;
                    if (left / Math.min(a, b) == 2) {
                        System.out.println(div + 2);
                    } else if (left < 2 * max) {
                        System.out.println(div + 2);
                    } else {
                        System.out.println(d / max + 2);
                    }
                }
            }
        }
    }
}
