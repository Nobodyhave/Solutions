package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 10/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-for-a-range
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        final int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }

        return new int[]{leftBoundary(nums, target, index), rightBoundary(nums, target, index)};
    }

    private static int leftBoundary(int[] nums, int target, int endIndex) {
        if (endIndex == 0) {
            return endIndex;
        }

        int start = 0, end = endIndex;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[start] == target ? start : start + 1;
    }

    private static int rightBoundary(int[] nums, int target, int startIndex) {
        if (startIndex == nums.length - 1) {
            return startIndex;
        }

        int start = startIndex, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nums[end] == target ? end : end - 1;
    }
}
