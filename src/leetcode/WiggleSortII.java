package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 21/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/wiggle-sort-ii
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        Arrays.sort(nums);
        int median = nums[nums.length / 2];

        int i = 0, j = 0, n = nums.length, k = n - 1;
        while (j <= k) {
            if (nums[virtualIndex(j, n)] > median) {
                swap(nums, virtualIndex(i++, n), virtualIndex(j++, n));
            } else if (nums[virtualIndex(j, n)] < median) {
                swap(nums, virtualIndex(j, n), virtualIndex(k--, n));
            } else {
                j++;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int virtualIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
}
