package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Aleksandr on 17/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/merge-intervals
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(new IntervalComparator());
        final Stack<Interval> stack = new Stack<>();
        for (Interval interval : intervals) {
            if (stack.isEmpty() || interval.start > stack.peek().end) {
                stack.push(interval);
            } else {
                stack.peek().end = Math.max(interval.end, stack.peek().end);
            }
        }

        return new ArrayList<>(stack);
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }

    private static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
