package leetcode;

/**
 * Created by Aleksandr on 02/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        final int[] sums = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            sums[i - k + 1] = sums[i - k] - nums[i - k] + nums[i];
        }

        final int[] maxLeft = new int[sums.length];
        maxLeft[0] = sums[0];
        for (int i = 1; i < sums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], sums[i]);
        }

        final int[] maxRight = new int[sums.length];
        maxRight[sums.length - 1] = sums[sums.length - 1];
        for (int i = sums.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], sums[i]);
        }

        int maxResult = Integer.MIN_VALUE, maxIndex = -1, maxResultLeft = Integer.MIN_VALUE, maxResultRight = Integer.MIN_VALUE;
        for (int i = 1; i <= sums.length - 2 * k; i++) {
            final int sum = maxLeft[i - 1] + sums[i + k - 1] + maxRight[i + 2 * k - 1];
            if (sum > maxResult) {
                maxResult = sum;
                maxResultLeft = maxLeft[i - 1];
                maxResultRight = maxRight[i + 2 * k - 1];
                maxIndex = i + k - 1;
            }
        }

        int maxIndexLeft = -1, maxIndexRight = -1;
        for (int i = 0; i < maxLeft.length; i++) {
            if (maxLeft[i] == maxResultLeft) {
                maxIndexLeft = i;
                break;
            }
        }
        for (int i = maxRight.length - 1; i >= 0; i--) {
            if (maxRight[i] == maxResultRight) {
                maxIndexRight = i;
                break;
            }
        }

        return new int[]{maxIndexLeft, maxIndex, maxIndexRight};
    }
}
