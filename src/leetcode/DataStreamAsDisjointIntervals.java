package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals
 */
public class DataStreamAsDisjointIntervals {
    private TreeMap<Integer, Interval> intervals;

    public DataStreamAsDisjointIntervals() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        if (intervals.containsKey(val)) {
            return;
        }

        Integer l = intervals.lowerKey(val);
        Integer h = intervals.higherKey(val);

        if (l != null && h != null && intervals.get(l).end + 1 == val && val + 1 == h) {
            intervals.get(l).end = intervals.get(h).end;
            intervals.remove(h);
        } else if (l != null && intervals.get(l).end + 1 >= val) {
            intervals.get(l).end = Math.max(intervals.get(l).end, val);
        } else if (h != null && h == val + 1) {
            intervals.put(val, new Interval(val, intervals.get(h).end));
            intervals.remove(h);
        } else {
            intervals.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(intervals.values());
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
