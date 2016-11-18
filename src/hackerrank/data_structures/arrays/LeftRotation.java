package hackerrank.data_structures.arrays;

/**
 * Created by Aleksandr on 17/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/array-left-rotation
 */

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int d = scanner.nextInt();

        final int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        reverse(arr, 0, d - 1);
        reverse(arr, d, N - 1);
        reverse(arr, 0, N - 1);

        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
