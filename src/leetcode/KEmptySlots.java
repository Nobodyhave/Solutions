package leetcode;

import java.util.TreeSet;

/**
 * Created by Aleksandr on 31/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/k-empty-slots
 */
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0) {
            return -1;
        }

        final TreeSet<Interval> set = new TreeSet<>();
        set.add(new Interval(0, flowers.length - 1));

        for (int i = 0; i < flowers.length; i++) {
            final int flower = flowers[i] - 1;
            final Interval interval = set.ceiling(new Interval(flower, flower));
            final int leftFlower = flower - (k + 1);
            final int rightFlower = flower + (k + 1);
            if ((leftFlower == interval.start - 1 && interval.start != 0) || (rightFlower == interval.end + 1 && interval.end != flowers.length - 1)) {
                return i + 1;
            } else {
                set.remove(interval);
                if (flower > interval.start) {
                    set.add(new Interval(interval.start, flower - 1));
                }
                if (flower < interval.end) {
                    set.add(new Interval(flower + 1, interval.end));
                }
            }
        }

        return -1;
    }

    private static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (start < o.start) {
                return -1;
            } else if (start > o.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
