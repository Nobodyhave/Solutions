package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-17/challenges/the-hurdle-race
 */
public class HurdleRace {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();
        final int[] height = new int[n];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }

        if (k >= maxHeight) {
            System.out.println(0);
        } else {
            System.out.println(maxHeight - k);
        }


    }
}
