package hackerrank.algorithms.greedy;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/mark-and-toys
 */

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        int K = in.nextInt();

        final int[] toys = new int[N];
        for (int i = 0; i < N; i++) {
            toys[i] = in.nextInt();
        }
        Arrays.sort(toys);

        int i = 0;
        int count = 0;
        while (i < N && K >= toys[i]) {
            K -= toys[i];
            count++;
            i++;
        }

        System.out.println(count);
    }
}
