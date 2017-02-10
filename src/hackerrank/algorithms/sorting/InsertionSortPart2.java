package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insertionsort2
 */
public class InsertionSortPart2 {
    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int j = i;
            while (j >= 1 && ar[j] < ar[j - 1]) {
                int temp = ar[j];
                ar[j] = ar[j - 1];
                ar[j - 1] = temp;
                j--;
            }
            printArray(ar);
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
