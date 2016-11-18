package hackerrank.data_structures.arrays;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/arrays-ds
 */

import java.util.Scanner;

public class ArraysDS {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int[] arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
