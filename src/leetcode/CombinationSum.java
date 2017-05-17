package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 11/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/combination-sum
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();

        goDeeper(result, new ArrayList<>(), candidates, target, 0, 0);

        return result;
    }

    private static void goDeeper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int sum, int start) {
        if (start >= candidates.length || sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            goDeeper(result, list, candidates, target, sum + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
