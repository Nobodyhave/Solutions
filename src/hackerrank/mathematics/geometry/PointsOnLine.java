package hackerrank.mathematics.geometry;

/**
 * Created by Aleksandr on 12/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/points-on-a-line
 */

import java.util.Scanner;

public class PointsOnLine {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        boolean sameX = true, sameY = true;
        int startX = in.nextInt(), startY = in.nextInt();
        for (int i = 1; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x != startX) {
                sameX = false;
            }
            if (y != startY) {
                sameY = false;
            }
        }

        if (sameX || sameY) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

