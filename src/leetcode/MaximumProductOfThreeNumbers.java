package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-product-of-three-numbers
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        final int n = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
