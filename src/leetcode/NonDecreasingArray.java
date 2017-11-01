package leetcode;

/**
 * Created by Aleksandr on 25/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/non-decreasing-array
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        boolean inversion = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    inversion = true;
                    continue;
                }

                if (inversion) {
                    return false;
                } else {
                    inversion = true;
                    if (nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = Math.max(nums[i - 1], nums[i]);
                    }
                }
            }
        }

        return true;
    }
}
