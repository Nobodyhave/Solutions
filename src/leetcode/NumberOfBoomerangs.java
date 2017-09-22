package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 13/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-of-boomerangs
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            final Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                final int dist = getDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (Integer n : map.values()) {
                count += n * (n - 1);
            }
        }

        return count;
    }

    private int getDistance(int[] p1, int[] p2) {
        final int dX = p1[0] - p2[0];
        final int dY = p1[1] - p2[1];

        return dX * dX + dY * dY;
    }
}
