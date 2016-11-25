package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 22/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/mini-max-sum
 */

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int[] a = new int[5];
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);

        System.out.println((sum - a[4]) + " " + (sum - a[0]));
    }
}

