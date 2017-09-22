package leetcode;

import java.util.TreeSet;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/heaters
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        if (heaters == null || houses == null || heaters.length == 0 || houses.length == 0) {
            return 0;
        }

        final TreeSet<Integer> heaterSet = new TreeSet<>();
        for (int heater : heaters) {
            heaterSet.add(heater);
        }

        int min = Integer.MIN_VALUE;
        for (int house : houses) {
            final Integer floor = heaterSet.floor(house);
            final Integer ceil = heaterSet.ceiling(house);
            final int floorDist = floor != null ? Math.abs(house - floor) : Integer.MAX_VALUE;
            final int ceilDist = ceil != null ? Math.abs(house - ceil) : Integer.MAX_VALUE;

            min = Math.max(min, Math.min(floorDist, ceilDist));
        }

        return min;
    }
}
