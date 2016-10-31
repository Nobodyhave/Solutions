package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 31/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-2d-arrays
 */

import java.util.Scanner;

public class Arrays2D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum =
                        arr[i - 1][j - 1]
                                + arr[i - 1][j]
                                + arr[i - 1][j + 1]
                                + arr[i][j]
                                + arr[i + 1][j - 1]
                                + arr[i + 1][j]
                                + arr[i + 1][j + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }
}

