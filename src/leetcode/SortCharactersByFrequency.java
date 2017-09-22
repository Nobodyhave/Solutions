package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 14/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sort-characters-by-frequency
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }

        final HeapIncreaseKey pq = new HeapIncreaseKey(256);
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (!pq.contains(c)) {
                pq.add(c, 1);
            } else {
                pq.increaseKey(c, pq.keyOf(c) + 1);
            }
        }

        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            final int count = pq.maxKey();
            final char c = (char) pq.poll();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static class HeapIncreaseKey {
        private int N;
        private int[] pq;
        private int[] qp;
        private int[] keys;

        HeapIncreaseKey(int N) {
            keys = new int[N + 1];
            pq = new int[N + 1];
            qp = new int[N + 1];
            Arrays.fill(qp, -1);
        }

        boolean isEmpty() {
            return N == 0;
        }

        boolean contains(int i) {
            return qp[i] != -1;
        }

        void add(int index, int key) {
            N++;
            qp[index] = N;
            pq[N] = index;
            keys[index] = key;
            swim(N);
        }

        int maxKey() {
            return keys[pq[1]];
        }

        int poll() {
            int max = pq[1];
            swap(1, N--);
            sink(1);

            qp[max] = -1;
            pq[N + 1] = -1;
            return max;
        }

        int keyOf(int i) {
            return keys[i];
        }


        void increaseKey(int index, int key) {
            keys[index] = key;
            swim(qp[index]);
        }

        private void swap(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        private boolean less(int i, int j) {
            return keys[pq[i]] < keys[pq[j]];
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                swap(k, j);
                k = j;
            }
        }
    }
}
