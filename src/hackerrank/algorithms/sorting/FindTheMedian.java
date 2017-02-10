package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/find-the-median
 */
public class FindTheMedian {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        partition(nums, 0, N - 1);

        System.out.println(nums[N / 2]);
    }

    private static void partition(int[] nums, int low, int high) {
        //System.out.println("Low: " + low + " High: " + high);
        //System.out.println(Arrays.toString(nums));
        int lt = low, gt = high;

        if (high <= low) {
            return;
        }
        int pivot = nums[low];
        int i = low;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, gt--, i);
            } else {
                i++;
            }
        }

        if (nums.length / 2 >= lt && nums.length / 2 <= gt) {
            return;
        } else if (nums.length / 2 > gt) {
            partition(nums, gt + 1, high);
        } else {
            partition(nums, low, lt - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
