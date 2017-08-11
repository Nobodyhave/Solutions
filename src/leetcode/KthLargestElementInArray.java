package leetcode;

/**
 * Created by Aleksandr on 13/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return find(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private static int find(int[] nums, int k, int lo, int hi) {
        int pivotPos = partition(nums, lo, hi);

        if (pivotPos == k - 1) {
            return nums[pivotPos];
        } else if (pivotPos > k - 1) {
            return find(nums, k, lo, pivotPos - 1);
        } else {
            return find(nums, k, pivotPos + 1, hi);
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        int x = nums[hi], i = lo;
        for (int j = lo; j <= hi - 1; j++) {
            if (nums[j] <= x) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);

        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
