package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        final int avgLow = ((nums.length & 1) == 0 ? nums[nums.length / 2 - 1] : nums[nums.length / 2]);
        final int avgHigh = nums[nums.length / 2];
        int stepsToLow = 0, stepsToHigh = 0;

        for (int i = 0; i < nums.length; i++) {
            stepsToLow += Math.abs(nums[i] - avgLow);
            stepsToHigh += Math.abs(nums[i] - avgHigh);
        }

        return Math.min(stepsToLow, stepsToHigh);
    }
}
