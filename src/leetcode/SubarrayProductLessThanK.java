package leetcode;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/subarray-product-less-than-k
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        final int N = nums.length;
        long product = 1;
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < N) {
            product *= nums[end];
            while (start <= end && product >= k) {
                product /= nums[start];
                start++;
            }
            result += (end - start + 1);
            end++;
        }
        return result;
    }
}
