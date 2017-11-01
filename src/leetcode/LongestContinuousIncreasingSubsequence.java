package leetcode;

/**
 * Created by Aleksandr on 27/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curCount = 1, maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                curCount = 1;
            }
        }
        maxCount = Math.max(maxCount, curCount);

        return maxCount;
    }
}
