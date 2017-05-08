package leetcode;

/**
 * Created by Aleksandr on 04/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/container-with-most-water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int start = 0, end = height.length - 1, maxArea = Integer.MIN_VALUE;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, area);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
