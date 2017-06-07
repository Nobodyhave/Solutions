package leetcode;

import java.util.Stack;

/**
 * Created by Aleksandr on 01/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/maximal-rectangle
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        final int[] heights = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        final Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE, i;
        for (i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int index = stack.pop();
                int h = heights[index];
                int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
                int area = h * w;
                if (area > max) {
                    max = area;
                }
                i--;
            }
        }

        i = heights.length;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = heights[index];
            int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
            int area = h * w;
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}
