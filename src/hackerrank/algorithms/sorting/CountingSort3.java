package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/countingsort3
 */
public class CountingSort3 {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final int[] count = new int[100];
        for (int i = 0; i < N; i++) {
            count[in.nextInt()]++;
            in.next();
        }
        int offset = 0;
        for (int aCount : count) {
            offset += aCount;
            System.out.print(offset + " ");
        }
    }
}
