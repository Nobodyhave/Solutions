package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-time-difference
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }

        final int[] tp = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            tp[i] = timeInMinutes(timePoints.get(i));
        }

        Arrays.sort(tp);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < tp.length; i++) {
            min = Math.min(min, tp[i] - tp[i - 1]);
        }
        min = Math.min(min, 24 * 60 - tp[tp.length - 1] + tp[0]);

        return min;
    }

    private int timeInMinutes(String time) {
        final String[] split = time.split(":");

        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
