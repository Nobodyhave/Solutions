package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        final Map<Integer, PriorityQueue<List<Integer>>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                final List<Integer> list = new ArrayList<>();
                list.add(num);
                if (!map.containsKey(num)) {
                    final PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new LengthComparator());
                    pq.add(list);
                    map.put(num, pq);
                } else {
                    map.get(num).add(list);
                }
            } else {
                final List<Integer> list = map.get(num - 1).poll();
                if (map.get(num - 1).isEmpty()) {
                    map.remove(num - 1);
                }
                list.add(num);
                if (!map.containsKey(num)) {
                    final PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new LengthComparator());
                    pq.add(list);
                    map.put(num, pq);
                } else {
                    map.get(num).add(list);
                }
            }
        }

        for (PriorityQueue<List<Integer>> set : map.values()) {
            for (List<Integer> list : set) {
                if (list.size() < 3) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class LengthComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> pq1, List<Integer> pq2) {
            return Integer.compare(pq1.size(), pq2.size());
        }
    }
}
