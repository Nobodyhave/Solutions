package hackerrank.data_structures.arrays;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/2d-array
 */

import java.util.Scanner;

public class Array2dDS {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int cur = 0;
                cur += arr[i - 1][j - 1];
                cur += arr[i - 1][j];
                cur += arr[i - 1][j + 1];
                cur += arr[i][j];
                cur += arr[i + 1][j - 1];
                cur += arr[i + 1][j];
                cur += arr[i + 1][j + 1];
                if (cur > max) {
                    max = cur;
                }
            }
        }
        System.out.println(max);
    }
}
