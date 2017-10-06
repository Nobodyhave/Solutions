package leetcode;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray
 */
public class ShortedUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        while (start < nums.length && nums[start] <= nums[start + 1]) {
            start++;
        }

        if (start == nums.length - 1) {
            return 0;
        }

        int end = nums.length - 1;
        while (nums[end] >= nums[end - 1]) {
            end--;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while (start >= 0 && nums[start] > min) {
            start--;
        }
        while (end < nums.length && nums[end] < max) {
            end++;
        }

        return end - start - 1;
    }
}
