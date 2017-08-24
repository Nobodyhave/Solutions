package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 21/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-of-range-sum
 */
public class CountOfRangeSum {
    int countRangeSum(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        long[] valSet = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet[i] = sum;
        }

        Arrays.sort(valSet);
        SegmentTree st = new SegmentTree(valSet);

        for (int i = nums.length - 1; i >= 0; i--) {
            st.updateSegmentTree(sum);
            sum -= (long) nums[i];
            ans += st.getCount((long) lower + sum, (long) upper + sum);
        }
        return ans;
    }

    private class SegmentTree {
        private long[] input;
        private int[] count;
        private long[] min;
        private long[] max;

        SegmentTree(long[] input) {
            this.input = input;
            final int segTreeSize = (int) Math.pow(2, (int) Math.ceil(Math.log(input.length) / Math.log(2))) * 2 - 1;
            min = new long[segTreeSize];
            max = new long[segTreeSize];
            count = new int[segTreeSize];

            buildSegmentTree(0, input.length - 1, 0);
        }

        private void buildSegmentTree(int low, int high, int present) {
            if (low > high) {
                return;
            }
            min[present] = input[low];
            max[present] = input[high];
            if (low == high) {
                return;
            }
            final int mid = (low + high) / 2;
            buildSegmentTree(low, mid, 2 * present + 1);
            buildSegmentTree(mid + 1, high, 2 * present + 2);
        }

        void updateSegmentTree(long val) {
            updateSegmentTree(0, input.length - 1, val, 0);
        }

        private void updateSegmentTree(int low, int high, long val, int present) {
            if (low > high) {
                return;
            }

            if (val >= min[present] && val <= max[present]) {
                count[present]++;
                if (low == high) {
                    return;
                }
                final int mid = (low + high) / 2;
                updateSegmentTree(low, mid, val, 2 * present + 1);
                updateSegmentTree(mid + 1, high, val, 2 * present + 2);
            }
        }

        int getCount(long minVal, long maxVal) {
            return getCount(0, input.length, minVal, maxVal, 0);
        }

        private int getCount(int low, int high, long minVal, long maxVal, int present) {
            if (low > high) {
                return 0;
            }
            if (minVal > max[present] || maxVal < min[present]) {
                return 0;
            }
            if (minVal <= min[present] && maxVal >= max[present]) {
                return count[present];
            }

            final int mid = (low + high) / 2;
            return getCount(low, mid, minVal, maxVal, 2 * present + 1) + getCount(mid + 1, high, minVal, maxVal, 2 * present + 2);
        }
    }
}
