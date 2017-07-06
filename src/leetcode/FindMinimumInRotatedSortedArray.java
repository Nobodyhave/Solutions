package leetcode;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        } else if(nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] >= nums[0]) {
                start = mid + 1;
            } else if(nums[mid] > nums[mid-1]) {
                end = mid - 1;
            } else {
                return nums[mid];
            }
        }

        return -1;
    }
}
