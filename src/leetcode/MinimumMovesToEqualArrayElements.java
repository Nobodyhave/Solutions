package leetcode;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }

        return sum - min * nums.length;
    }
}
