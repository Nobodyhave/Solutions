package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 25/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        final PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a, b) -> (int) (a.sum - b.sum));
        for (int i = 0; i < k && i < nums1.length; i++) {
            queue.add(new Pair(0, nums1[i], nums2[0]));
        }

        while (result.size() != k && !queue.isEmpty()) {
            final Pair pair = queue.poll();
            result.add(pair.pair);
            if (pair.idx < nums2.length - 1) {
                queue.add(new Pair(pair.idx + 1, pair.pair[0], nums2[pair.idx + 1]));
            }
        }

        return result;
    }

    private static class Pair {
        private int[] pair;
        private int idx;
        private long sum;

        Pair(int idx, int n1, int n2) {
            this.idx = idx;
            pair = new int[]{n1, n2};
            sum = (long) n1 + (long) n2;
        }
    }
}
