package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 30/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/lexicographical-numbers
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        final List<Integer> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        dfs(result, 0, n);

        return result;
    }

    private void dfs(List<Integer> result, int num, int n) {
        if (num > n) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (num + i <= n && num + i > 0) {
                result.add(num + i);
                dfs(result, (num + i) * 10, n);
            }
        }
    }
}
