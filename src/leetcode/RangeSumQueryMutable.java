package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/range-sum-query-mutable
 */
public class RangeSumQueryMutable {
    private SegmentTree segmentTree;

    public RangeSumQueryMutable(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int i, int val) {
        segmentTree.update(i, i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.sumQuery(i, j);
    }

    private static class SegmentTree {
        private int[] input;
        private int[] values;
        private int[] lazyValues;

        SegmentTree(int[] nums) {
            this.input = nums;
            final int segTreeSize = (int) Math.pow(2, (int) Math.ceil(Math.log(nums.length) / Math.log(2))) * 2 - 1;
            values = new int[segTreeSize];
            lazyValues = new int[segTreeSize];
            createSegmentTree(0, input.length - 1, 0);
        }

        private void createSegmentTree(int lo, int hi, int present) {
            if(lo == hi) {
                values[present] = input[lo];
            } else {
                int mid = lo + (hi - lo) / 2;

                createSegmentTree(lo, mid, 2 * present + 1);
                createSegmentTree(mid + 1, hi, 2 * present + 2);

                values[present] = values[2 * present + 1] + values[2 * present + 2];
            }
        }

        public int sumQuery(int lo, int hi) {
            return sumQuery(0, input.length - 1, lo, hi, 0);
        }

        private int sumQuery(int lo, int hi, int qLo, int qHi, int present) {
            if(qHi < lo || qLo > hi) {
                return 0;
            }

            if(lazyValues[present] != 0) {
                values[present] += lazyValues[present];

                if(lo != hi) {
                    lazyValues[2 * present + 1] += lazyValues[present];
                    lazyValues[2 * present + 2] += lazyValues[present];
                }

                lazyValues[present] = 0;
            }

            if(lo >= qLo && hi <= qHi) {
                return values[present];
            }

            int mid = lo + (hi - lo) / 2;

            return sumQuery(lo, mid, qLo, qHi, 2 * present + 1) + sumQuery(mid + 1, hi, qLo, qHi, 2 * present + 2);
        }

        public void update(int lo, int hi, int x) {
            update(0, input.length - 1, lo, hi, 0,  x - input[lo]);
            input[lo] = x;
        }

        public void update(int lo, int hi, int qLo, int qHi, int present, int x) {
            if(qHi < lo || qLo > hi) {
                return;
            }

            if(lazyValues[present] != 0) {
                values[present] += lazyValues[present];

                if(lo != hi) {
                    lazyValues[2 * present + 1] += lazyValues[present];
                    lazyValues[2 * present + 2] += lazyValues[present];
                }

                lazyValues[present] = 0;
            }

            if(lo >= qLo && hi <= qHi) {
                values[present] += x;

                if(lo != hi) {
                    lazyValues[2 * present + 1] += x;
                    lazyValues[2 * present + 2] += x;
                }

                return;
            }

            int mid = lo + (hi - lo) / 2;

            update(lo, mid, qLo, qHi, 2 * present + 1, x);
            update(mid + 1, hi, qLo, qHi, 2 * present + 2, x);

            values[present] = values[2 * present + 1] + values[2 * present + 2];
        }
    }
}
