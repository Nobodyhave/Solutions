package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/correctness-invariant
 */
public class CorrectnessAndLoopInvariant {
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j > 0 && A[j] < A[j - 1]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);
    }
}
