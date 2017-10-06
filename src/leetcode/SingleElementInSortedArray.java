package leetcode;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/single-element-in-a-sorted-array
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
