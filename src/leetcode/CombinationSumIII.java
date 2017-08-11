package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 14/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/combination-sum-iii
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> result = new ArrayList<>();

        if (k == 0 || n == 0) {
            return result;
        }

        goDeeper(result, new ArrayList<>(), k, n, 1, 0);

        return result;
    }

    private static void goDeeper(List<List<Integer>> result, List<Integer> current, int k, int n, int start, int sum) {
        if (k == 0) {
            if (sum == n) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            goDeeper(result, current, k - 1, n, i + 1, sum + i);
            current.remove(current.size() - 1);
        }
    }
}
