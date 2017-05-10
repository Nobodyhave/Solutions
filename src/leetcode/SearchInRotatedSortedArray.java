package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 10/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        } else if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            } else {
                return -1;
            }
        }

        if (nums[0] < nums[nums.length - 1]) {
            final int index = Arrays.binarySearch(nums, target);
            return index >= 0 ? index : -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
