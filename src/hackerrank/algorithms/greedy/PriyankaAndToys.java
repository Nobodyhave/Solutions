package hackerrank.algorithms.greedy;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/priyanka-and-toys
 */

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] toys = new int[N];
        for (int i = 0; i < N; i++) {
            toys[i] = in.nextInt();
        }

        Arrays.sort(toys);

        int units = 1;
        int curWeight = toys[0];
        for (int i = 1; i < N; i++) {
            if (toys[i] > curWeight + 4) {
                units++;
                curWeight = toys[i];
            }
        }

        System.out.println(units);
    }
}
