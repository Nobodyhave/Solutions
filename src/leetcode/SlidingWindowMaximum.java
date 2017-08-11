package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 20/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        final int[] result = new int[nums.length - k + 1];
        int rIndex = 0;
        final Deque<Entry> window = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!window.isEmpty() && window.peekLast().num <= nums[i]) {
                window.pollLast();
            }
            window.addLast(new Entry(nums[i], i));

            while (window.peekFirst().index <= i - k) {
                window.pollFirst();
            }

            if (i >= k - 1) {
                result[rIndex++] = window.peekFirst().num;
            }
        }

        return result;
    }

    private static class Entry {
        private int num;
        private int index;

        public Entry(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
