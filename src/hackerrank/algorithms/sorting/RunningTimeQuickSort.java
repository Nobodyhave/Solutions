package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/quicksort4
 */
public class RunningTimeQuickSort {
    private static int insertionSwap = 0;
    private static int quickSwap = 0;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] nums1 = new int[n];
        final int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
            nums2[i] = nums1[i];
        }
        quickSort(nums1);
        insertionSortPart2(nums2);

        System.out.println(insertionSwap - quickSwap);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int from, int to) {

        if ((to - from) >= 1) {
            int pivotPosition = partition(array, from, to);
            //print(array);
            // Sort the left part of the array
            quickSort(array, from, pivotPosition - 1);
            // Sort the left part of the array
            quickSort(array, pivotPosition + 1, to);
        }

    }

    private static int partition(int[] array, int from, int to) {

        int pivot = array[to];
        int wallIndex = from;

        for (int currentIndex = from; currentIndex < to; ++currentIndex) {

            if (array[currentIndex] < pivot) {
                swap(array, wallIndex, currentIndex);
                ++wallIndex;
            }

        }

        swap(array, wallIndex, to);

        return wallIndex;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        quickSwap++;
    }

    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int j = i;
            while (j >= 1 && ar[j] < ar[j - 1]) {
                int temp = ar[j];
                ar[j] = ar[j - 1];
                ar[j - 1] = temp;
                j--;
                insertionSwap++;
            }
            //printArray(ar);
        }
    }
}
