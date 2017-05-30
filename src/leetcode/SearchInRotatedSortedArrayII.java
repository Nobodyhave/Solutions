package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return nums[0] == target;
        } else if (nums.length == 2) {
            return nums[0] == target || nums[1] == target;
        }

        if (nums[0] < nums[nums.length - 1]) {
            final int index = Arrays.binarySearch(nums, target);
            return index >= 0;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                end--;
            }
        }

        return false;
    }
}
