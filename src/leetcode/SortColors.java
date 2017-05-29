package leetcode;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sort-colors
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0, lt = i, gt = nums.length - 1;

        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
