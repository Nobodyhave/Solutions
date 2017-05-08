package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result - 1]) {
                int temp = nums[result];
                nums[result] = nums[i];
                nums[i] = temp;
                result++;
            }

        }

        return result;
    }
}
