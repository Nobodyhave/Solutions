package leetcode;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                final int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}
