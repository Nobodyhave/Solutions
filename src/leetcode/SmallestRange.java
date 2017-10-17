package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/smallest-range
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        final PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            final Element e = new Element(i, 0, nums.get(i).get(0));
            pq.add(e);
            max = Math.max(max, nums.get(i).get(0));
        }

        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {
            final Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()) {
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }

    private static class Element {
        private int val;
        private int idx;
        private int row;

        Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
