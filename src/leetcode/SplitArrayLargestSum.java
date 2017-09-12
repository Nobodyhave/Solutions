package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/split-array-largest-sum
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m < 1) {
            return 0;
        }

        long sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        long start = max, end = sum;
        while (start <= end) {
            final long mid = start + (end - start) / 2;

            if (isValid(nums, m, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) start;
    }

    private boolean isValid(int[] nums, int m, long sum) {
        int curSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > sum) {
                count++;
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
        }

        return count + 1 <= m;
    }
}
