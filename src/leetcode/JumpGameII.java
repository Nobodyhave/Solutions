package leetcode;

/**
 * Created by Aleksandr on 15/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/jump-game-ii
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int curDist = nums[0], maxDist = nums[0], jumps = 1;

        for (int i = 1; i < nums.length; i++) {
            if (i <= curDist) {
                maxDist = Math.max(maxDist, i + nums[i]);
            } else {
                jumps++;
                curDist = maxDist;
                maxDist = Math.max(maxDist, i + nums[i]);
            }
        }

        return jumps;
    }
}
