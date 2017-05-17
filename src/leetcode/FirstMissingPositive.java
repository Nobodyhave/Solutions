package leetcode;

/**
 * Created by Aleksandr on 12/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/first-missing-positive
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        } else if (nums.length == 1) {
            return nums[0] != 1 ? 1 : 2;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] > 0) {
                swap(nums, start, end);
                end--;
            } else {
                start++;
            }
        }

        if (start == nums.length) {
            return 1;
        }

        int offset = end + 1;

        for (int i = offset; i < nums.length; i++) {
            if (Math.abs(nums[i]) - 1 + offset < nums.length && nums[Math.abs(nums[i]) - 1 + offset] > 0) {
                nums[Math.abs(nums[i]) - 1 + offset] = -nums[Math.abs(nums[i]) - 1 + offset];
            }
        }

        int index = -1;
        for (int i = offset; i < nums.length; i++) {
            if (nums[i] > 0) {
                index = i - offset;
                break;
            }
        }

        if (index == -1) {
            index = nums.length - offset;
        }

        return index + 1;
    }

    private static void swap(int[] a, int i, int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
