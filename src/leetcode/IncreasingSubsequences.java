package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 22/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/increasing-subsequences
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return result;
        }

        final Set<String> sequences = new HashSet<>();
        dfs(sequences, nums, new StringBuilder(), Integer.MIN_VALUE, 0, 0);

        for (String s : sequences) {
            final String[] split = s.split("#");
            final List<Integer> list = new ArrayList<>();
            for (String str : split) {
                if (!str.isEmpty()) {
                    list.add(Integer.parseInt(str));
                }
            }
            result.add(list);
        }

        return result;
    }

    private void dfs(Set<String> result, int[] nums, StringBuilder current, int prev, int count, int depth) {
        if (count >= 2) {
            result.add(current.toString());
        }
        if (depth == nums.length) {
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            if (nums[i] >= prev) {
                int prevLength = current.length();
                current.append("#").append(nums[i]);
                dfs(result, nums, current, nums[i], count + 1, i + 1);
                current.delete(prevLength, current.length());
            } else {
                dfs(result, nums, current, prev, count, i + 1);
            }
        }
    }
}
