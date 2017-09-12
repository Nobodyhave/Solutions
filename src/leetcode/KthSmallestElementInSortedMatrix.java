package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 28/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k < 1) {
            return 0;
        }

        final PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            pq.add(new Entry(matrix[i][0], i, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            final Entry entry = pq.poll();
            if (entry.col < matrix[0].length - 1) {
                pq.add(new Entry(matrix[entry.row][entry.col + 1], entry.row, entry.col + 1));
            }
        }

        return pq.poll().val;
    }

    private static class Entry implements Comparable<Entry> {
        private int val;
        private int row;
        private int col;

        Entry(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(val, o.val);
        }
    }
}
