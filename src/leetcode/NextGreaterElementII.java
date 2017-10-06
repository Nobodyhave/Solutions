package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/next-greater-element-ii
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        final int[] rep = new int[2 * nums.length];
        System.arraycopy(nums, 0, rep, 0, nums.length);
        System.arraycopy(nums, 0, rep, nums.length, nums.length);

        final Deque<Integer> stack = new ArrayDeque<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rep.length; i++) {
            if (stack.isEmpty() || rep[i] <= rep[stack.peek()]) {
                stack.offerFirst(i);
            } else {
                while (!stack.isEmpty() && rep[stack.peek()] < rep[i]) {
                    map.putIfAbsent(stack.pollFirst(), rep[i]);
                }
                stack.offerFirst(i);
            }
        }

        final int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault(i, -1);
        }

        return result;
    }
}
