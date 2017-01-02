package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/strange-code
 */
public class StrangeCounter {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final long t = in.nextLong();

        long start = 3;
        long sum = 0;

        while (sum + start <= t) {
            sum += start;
            start *= 2;
        }

        System.out.println(start - (t - sum - 1));
    }
}
