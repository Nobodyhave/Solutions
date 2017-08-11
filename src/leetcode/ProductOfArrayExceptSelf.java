package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        final int[] toLeft = new int[nums.length];
        final int[] toRight = new int[nums.length];

        toLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            toLeft[i] = toLeft[i - 1] * nums[i - 1];
        }
        toRight[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            toRight[i] = toRight[i + 1] * nums[i + 1];
        }

        final int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = toLeft[i] * toRight[i];
        }

        return result;
    }
}
