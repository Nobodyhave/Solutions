package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 11/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/combination-sum
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        final Set<List<Integer>> result = new HashSet<>();

        goDeeper(result, new ArrayList<>(), candidates, target, 0, 0);

        return new ArrayList<>(result);
    }

    private static void goDeeper(Set<List<Integer>> result, List<Integer> list, int[] candidates, int target, int sum, int start) {
        if (start > candidates.length || sum > target) {
            return;
        } else if (sum == target) {
            ArrayList<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            result.add(copy);
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            goDeeper(result, list, candidates, target, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
