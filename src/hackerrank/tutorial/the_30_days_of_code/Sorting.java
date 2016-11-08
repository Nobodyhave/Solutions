package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-sorting
 */

import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int numberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }

            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.format("Array is sorted in %d swaps.\n", numberOfSwaps);
        System.out.format("First Element: %d \n", a[0]);
        System.out.format("Last Element: %d \n", a[n - 1]);
    }
}

