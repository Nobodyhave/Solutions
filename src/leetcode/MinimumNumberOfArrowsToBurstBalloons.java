package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aleksandr on 15/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int x = points[0][1], shots = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= x) {
                continue;
            }

            x = points[i][1];
            shots++;
        }

        return shots;
    }
}
