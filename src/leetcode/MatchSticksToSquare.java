package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 19/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/matchsticks-to-square
 */
public class MatchSticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);

        return dfs(nums, new int[4], sum / 4, 0);
    }

    private boolean dfs(int[] nums, int[] sides, int side, int start) {
        if (start == nums.length) {
            return sides[0] == side && sides[1] == side && sides[2] == side;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + nums[start] > side) {
                continue;
            }
            sides[i] += nums[start];
            if (dfs(nums, sides, side, start + 1)) {
                return true;
            }
            sides[i] -= nums[start];
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            final int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
