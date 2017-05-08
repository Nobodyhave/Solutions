package leetcode;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int start = 0, end = nums.length - 1;

        int result = nums.length;
        while (start <= end) {
            if (nums[start] == val) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
                result--;
            } else {
                start++;
            }
        }

        return result;
    }
}
