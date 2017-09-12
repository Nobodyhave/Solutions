package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/non-overlapping-intervals
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        final Deque<Interval> stack = new ArrayDeque<>();
        int count = 0;
        for (Interval interval : intervals) {
            if (stack.isEmpty() || stack.peek().end <= interval.start) {
                stack.addFirst(interval);
            } else if (stack.peek().end > interval.start && stack.peek().end >= interval.end) {
                stack.removeFirst();
                stack.addFirst(interval);
                count++;
            } else if (stack.peek().end > interval.start && stack.peek().end <= interval.end) {
                count++;
            }
        }

        return count;
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
