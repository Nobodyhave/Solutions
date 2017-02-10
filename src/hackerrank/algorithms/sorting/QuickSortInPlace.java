package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/quicksort3
 */
public class QuickSortInPlace {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final QuickSortInPlace solution = new QuickSortInPlace();

        final int size = scanner.nextInt();
        final int[] array = new int[size];

        for (int i = 0; i < size; ++i) {
            array[i] = scanner.nextInt();
        }

        solution.quickSort(array);
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int from, int to) {

        if ((to - from) >= 1) {
            int pivotPosition = partition(array, from, to);
            print(array);
            // Sort the left part of the array
            quickSort(array, from, pivotPosition - 1);
            // Sort the left part of the array
            quickSort(array, pivotPosition + 1, to);
        }

    }

    private int partition(int[] array, int from, int to) {

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

    private void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private void print(int[] array) {

        for (int element : array) {
            print(element);
        }

        System.out.println("");
    }

    private void print(int element) {
        System.out.print(Integer.toString(element) + " ");
    }
}
