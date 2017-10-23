package leetcode;

/**
 * Created by Aleksandr on 18/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-average-subarray-i
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}
