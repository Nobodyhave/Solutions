package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 09/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/next-permutation
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        } else if (isLastPermutation(nums)) {
            reverseArray(nums);
            return;
        }

        int left = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                left = i;
            }
        }

        int right = nums.length - 1;
        for (int i = right; i > 0; i--) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        Arrays.sort(nums, left + 1, nums.length);
    }

    private boolean isLastPermutation(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                return false;
            }
        }

        return true;
    }

    private void reverseArray(int[] a) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
