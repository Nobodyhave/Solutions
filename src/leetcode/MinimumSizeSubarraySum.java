package leetcode;

/**
 * Created by Aleksandr on 13/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-size-subarray-sum
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
