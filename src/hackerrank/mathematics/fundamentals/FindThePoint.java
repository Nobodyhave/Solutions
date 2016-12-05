package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by Aleksandr on 01/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/find-point
 */
public class FindThePoint {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            final int pX = in.nextInt();
            final int pY = in.nextInt();
            final int qX = in.nextInt();
            final int qY = in.nextInt();

            int rX, rY;
            if (pX < qX) {
                rX = qX + (qX - pX);
            } else {
                rX = qX - (pX - qX);
            }

            if (pY < qY) {
                rY = qY + (qY - pY);
            } else {
                rY = qY - (pY - qY);
            }

            System.out.println(rX + " " + rY);
        }
    }
}
