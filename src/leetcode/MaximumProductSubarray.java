package leetcode;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-product-subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0], max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);

            result = Math.max(result, max);
        }

        return result;
    }
}
