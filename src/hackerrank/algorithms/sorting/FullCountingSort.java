package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/countingsort4
 */
public class FullCountingSort {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final int[] count = new int[101];
        final String[] data = new String[N];
        for (int i = 0; i < N; i++) {
            count[in.nextInt() + 1]++;
            data[i] = in.next();
        }
        for (int i = 0; i < 100; i++) {
            count[i + 1] += count[i];
        }

        final String[] aux = new String[N];
        for (int i = 0; i < N; i++) {
            aux[count[i]++] = data[i];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(aux[i]);
        }
    }
}
