package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 22/03/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class CandyReplenishRobot {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int t = in.nextInt();
        final int[] c = new int[t];
        for (int i = 0; i < t; i++) {
            c[i] = in.nextInt();
        }

        int sum = 0;
        int count = n;
        for (int i = 0; i < t - 1; i++) {
            count -= c[i];
            if (count < 5) {
                sum += n - count;
                count = n;
            }
        }

        System.out.println(sum);
    }
}
