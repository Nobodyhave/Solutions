package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 21/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sliding-window-median
 */
public class SlidingWindowMedian {
    private BinaryHeap minPq;
    private BinaryHeap maxPq;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }

        final int n = nums.length;
        final double[] result = new double[n - k + 1];
        minPq = new BinaryHeap(n, false);
        maxPq = new BinaryHeap(n, true);

        for (int i = 0; i < n; i++) {
            addNum(i, nums[i]);
            System.out.format("i: %d\nminPqSize: %d minPq %s\nmaxPqSize: %d maxPq %s\n-------\n", i, minPq.size(), Arrays.toString(minPq.pq), maxPq.size(), Arrays.toString(maxPq.pq));
            if (i >= k - 1) {
                result[i - k + 1] = findMedian();
                removeNum(i - k + 1);
            }


        }

        return result;
    }

    private void removeNum(int index) {
        if (maxPq.contains(index)) {
            maxPq.delete(index);
        } else {
            minPq.delete(index);
        }

        if (maxPq.size() >= minPq.size() + 2) {
            minPq.add(maxPq.poll());
        } else if (minPq.size() > maxPq.size()) {
            maxPq.add(minPq.poll());
        }
    }

    private void addNum(int index, int num) {
        if (maxPq.isEmpty()) {
            maxPq.add(index, num);
        } else if (minPq.isEmpty()) {
            if (num >= maxPq.peek()) {
                minPq.add(index, num);
            } else {
                maxPq.add(index, num);
                minPq.add(maxPq.poll());
            }
        } else if (maxPq.size() > minPq.size()) {
            if (num >= maxPq.peek()) {
                minPq.add(index, num);
            } else {
                maxPq.add(index, num);
                minPq.add(maxPq.poll());
            }
        } else if (maxPq.size() == minPq.size()) {
            if (num < maxPq.peek()) {
                maxPq.add(index, num);
            } else {
                minPq.add(index, num);
                maxPq.add(minPq.poll());
            }
        }
    }

    private double findMedian() {
        if (maxPq.isEmpty() && minPq.isEmpty()) {
            return 0;
        } else if (maxPq.size() > minPq.size()) {
            return maxPq.peek();
        } else {
            return ((double) maxPq.peek() + (double) minPq.peek()) / 2.0;
        }
    }

    private static class BinaryHeap {
        private int N;
        private int[] pq;
        private int[] qp;
        private int[] keys;
        private boolean isMax;

        BinaryHeap(int N, boolean isMax) {
            this.isMax = isMax;
            keys = new int[N + 1];
            pq = new int[N + 1];
            qp = new int[N + 1];
            Arrays.fill(qp, -1);
        }

        boolean isEmpty() {
            return N == 0;
        }

        int size() {
            return N;
        }

        boolean contains(int i) {
            return qp[i] != -1;
        }

        void add(int[] pair) {
            add(pair[0], pair[1]);
        }

        void add(int index, int key) {
            N++;
            qp[index] = N;
            pq[N] = index;
            keys[index] = key;
            swim(N);
        }

        void delete(int i) {
            int index = qp[i];
            swap(index, N--);
            swim(index);
            sink(index);
            qp[i] = -1;
        }

        int peek() {
            return keys[pq[1]];
        }

        int[] poll() {
            final int keyIndex = pq[1];
            final int key = keys[keyIndex];
            swap(1, N--);
            sink(1);

            qp[keyIndex] = -1;
            pq[N + 1] = -1;

            return new int[]{keyIndex, key};
        }

        int keyOf(int i) {
            return keys[i];
        }

        private void swap(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        private boolean compare(int i, int j) {
            if (isMax) {
                return keys[pq[i]] < keys[pq[j]];
            } else {
                return keys[pq[i]] > keys[pq[j]];
            }
        }

        private void swim(int k) {
            while (k > 1 && compare(k / 2, k)) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && compare(j, j + 1)) {
                    j++;
                }
                if (!compare(k, j)) {
                    break;
                }
                swap(k, j);
                k = j;
            }
        }
    }
}
