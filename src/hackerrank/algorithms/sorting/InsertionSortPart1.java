package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insertionsort1
 */
public class InsertionSortPart1 {
    public static void insertIntoSorted(int[] ar) {
        final int ins = ar[ar.length - 1];
        int i = ar.length - 2;
        while (i >= 0 && ins < ar[i]) {
            ar[i + 1] = ar[i];
            printArray(ar);
            i--;
        }
        ar[i + 1] = ins;
        printArray(ar);
    }


    /* Tail starts here */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
