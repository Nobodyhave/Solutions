package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 19/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */

import java.util.Scanner;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        reverseArray(a, 0, k - 1);
        reverseArray(a, k, n - 1);
        reverseArray(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

