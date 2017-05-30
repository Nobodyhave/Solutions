package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/combinations
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }

        goDeeper(result, new ArrayList<>(), 1, n, k);

        return result;
    }

    private static void goDeeper(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            goDeeper(result, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
