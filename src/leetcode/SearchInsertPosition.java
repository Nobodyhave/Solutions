package leetcode;

/**
 * Created by Aleksandr on 10/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/search-insert-position
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        if (end >= 0 && nums[end] > target) {
            return end;
        } else {
            return start;
        }
    }
}
