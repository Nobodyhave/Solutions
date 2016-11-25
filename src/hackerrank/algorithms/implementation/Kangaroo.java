package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 25/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/kangaroo
 */

import java.util.Scanner;

public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int x1 = in.nextInt();
        final int v1 = in.nextInt();
        final int x2 = in.nextInt();
        final int v2 = in.nextInt();

        if (x1 > x2) {
            if (v1 >= v2) {
                System.out.println("NO");
            } else if ((x1 - x2) % (v2 - v1) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else if (x1 < x2) {
            if (v2 >= v1) {
                System.out.println("NO");
            } else if ((x2 - x1) % (v1 - v2) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("YES");
        }
    }
}

