package leetcode;

/**
 * Created by Aleksandr on 12/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/trapping-rain-water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int l = height.length;

        int[] maxLeft = new int[l];
        maxLeft[0] = height[0];
        for (int i = 1; i < l; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        int[] maxRight = new int[l];
        maxRight[l - 1] = height[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < l - 1; i++) {
            sum += Math.max(Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i], 0);
        }

        return sum;
    }
}
