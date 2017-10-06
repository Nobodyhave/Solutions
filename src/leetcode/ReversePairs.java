package leetcode;

/**
 * Created by Aleksandr on 25/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-pairs
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        return mergeSortWithCounting(nums);
    }

    private int mergeSortWithCounting(int[] nums) {
        return internalMergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int internalMergeSort(int[] nums, int[] aux, int low, int high) {
        if (low >= high) {
            return 0;
        }

        final int mid = low + (high - low) / 2;
        int count = internalMergeSort(nums, aux, low, mid) + internalMergeSort(nums, aux, mid + 1, high);

        for (int i = low, j = mid + 1; i <= mid; i++) {
            while (j <= high && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        merge(nums, aux, low, high, mid);

        return count;
    }

    private void merge(int[] nums, int[] aux, int low, int high, int mid) {
        System.arraycopy(nums, low, aux, low, high - low + 1);

        int l = low, r = mid + 1, i = low;
        while (l <= mid || r <= high) {
            if (l <= mid && r <= high) {
                if (aux[l] <= aux[r]) {
                    nums[i] = aux[l++];
                } else {
                    nums[i] = aux[r++];
                }
            } else if (l <= mid) {
                nums[i] = aux[l++];
            } else if (r <= high) {
                nums[i] = aux[r++];
            }
            i++;
        }
    }
}
