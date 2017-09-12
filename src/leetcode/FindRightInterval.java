package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }

        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        final int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry != null ? entry.getValue() : -1;
        }

        return result;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
