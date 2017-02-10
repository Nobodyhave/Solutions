package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/quicksort2
 */
public class QuickSort2Sorting {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final QuickSort2Sorting solution = new QuickSort2Sorting();

        final int size = scanner.nextInt();
        final int[] array = new int[size];

        int index = 0;
        while (scanner.hasNextInt()) {
            array[index++] = scanner.nextInt();
        }

        solution.quickSort(array, 0, array.length);
    }

    public void quickSort(int[] array, int left, int right) {

        if (right - left >= 2) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot);
            quickSort(array, (pivot + 1), right);
            print(array, left, right);
        }
    }

    public int partition(int[] array, int left, int right) {

        final int pivot = array[left];
        final List<Integer> smallerElements = new ArrayList<>(array.length);
        final List<Integer> largerElements = new ArrayList<>(array.length);

        for (int i = left + 1; i < right; ++i) {
            if (array[i] < pivot) {
                smallerElements.add(array[i]);
            } else {
                largerElements.add(array[i]);
            }
        }

        for (int i = 0; i < smallerElements.size(); ++i) {
            array[left + i] = smallerElements.get(i);
        }

        array[left + smallerElements.size()] = pivot;

        for (int i = 0; i < largerElements.size(); ++i) {
            array[left + smallerElements.size() + 1 + i] = largerElements.get(i);
        }

        return left + smallerElements.size();
    }

    private void print(int[] array, int left, int right) {
        for (int i = left; i < right; ++i) {
            print(array[i]);
        }
        System.out.println("");
    }

    private void print(int element) {
        System.out.print(Integer.toString(element) + " ");
    }
}
