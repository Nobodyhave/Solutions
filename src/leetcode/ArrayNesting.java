package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 14/12/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/array-nesting
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int[] S = new int[nums.length];
        Arrays.fill(S, -1);
        outer:
        for (int i = 0; i < nums.length; i++) {
            if (S[i] == -1) {
                final boolean[] marked = new boolean[nums.length];
                marked[i] = true;
                int dist = 1, idx = i;
                while (!marked[nums[idx]]) {
                    idx = nums[idx];
                    if (S[idx] != -1) {
                        dist += S[idx];
                        S[i] = dist;
                        continue outer;
                    } else {
                        marked[idx] = true;
                        dist++;
                    }
                }

                for (int j = 0; j < nums.length; j++) {
                    if (marked[j]) {
                        S[j] = dist;
                    }
                }
            }
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, S[i]);
        }

        return result;
    }
}
