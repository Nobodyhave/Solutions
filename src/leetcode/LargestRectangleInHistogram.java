package leetcode;

import java.util.Stack;

/**
 * Created by Aleksandr on 31/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/largest-rectangle-in-histogram
 */
public class LargestRectangleInHistogram {
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
