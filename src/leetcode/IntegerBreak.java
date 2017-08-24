package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/integer-break
 */
public class IntegerBreak {
    private Map<Integer, Integer> CACHE = new HashMap<>();

    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }

        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * dfs(n - i));
            max = Math.max(max, i * (n - i));
        }

        CACHE.put(n, max);

        return max;
    }
}
