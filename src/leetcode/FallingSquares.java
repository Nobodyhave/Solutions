package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/falling-squares
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        final List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return result;
        }

        final int[] heights = new int[positions.length];
        int maxHeight = positions[0][1];
        result.add(maxHeight);
        heights[0] = maxHeight;
        for (int i = 1; i < positions.length; i++) {
            maxHeight = Math.max(maxHeight, getHeight(positions, heights, i));
            result.add(maxHeight);
        }

        return result;
    }

    private int getHeight(int[][] positions, int[] heights, int curIndex) {
        int height = positions[curIndex][1];

        for (int i = 0; i < curIndex; i++) {
            if (positions[curIndex][0] > positions[i][0] + positions[i][1] - 1) {
                continue;
            }
            if (positions[curIndex][0] + positions[curIndex][1] - 1 < positions[i][0]) {
                continue;
            }

            height = Math.max(height, heights[i] + positions[curIndex][1]);
        }

        heights[curIndex] = height;

        return height;
    }
}
