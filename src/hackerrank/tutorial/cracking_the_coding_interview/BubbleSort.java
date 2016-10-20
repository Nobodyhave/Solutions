package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 */

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            int currentSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    currentSwaps++;
                    totalSwaps++;
                }
            }
            if (currentSwaps == 0) {
                break;
            }
        }

        System.out.format("Array is sorted in %d swaps.\n", totalSwaps);
        System.out.format("First Element: %d\n", a[0]);
        System.out.format("Last Element: %d\n", a[n - 1]);
    }
}
