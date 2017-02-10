package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/quicksort1
 */
public class QuickSort1Partition {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        final int pivot = nums[0];
        int lt = 0, gt = n - 1;
        for (int i = 1; i <= gt; i++) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
            } else if (nums[i] > pivot) {
                swap(nums, gt, i);
                gt--;
                i--;
            } else {
                // Do nothing
            }
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
