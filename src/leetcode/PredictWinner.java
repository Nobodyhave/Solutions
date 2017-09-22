package leetcode;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 */
public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        final int[][][] dp = new int[nums.length][nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i][0] = nums[i];
        }

        for(int k = 1; k < nums.length; k++) {
            for(int row = 0, col = k; col < nums.length; row++, col++) {
                int first = nums[row] + dp[row + 1][col][1];
                int second = nums[col] + dp[row][col - 1][1];

                if(first > second) {
                    dp[row][col][0] = first;
                    dp[row][col][1] = dp[row + 1][col][0];
                } else {
                    dp[row][col][0] = second;
                    dp[row][col][1] = dp[row][col - 1][0];
                }
            }
        }

        return dp[0][nums.length - 1][0] >= dp[0][nums.length - 1][1];
    }
}
