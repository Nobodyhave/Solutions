package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/ones-and-zeroes
 */
public class OnesAndZeroes {
    private final Map<Key, Integer> CACHE = new HashMap<>();

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }

        //return topDown(strs, m, n, 0, 0);
        return bottomUp(strs, m, n);
    }

    private int bottomUp(String[] strs, int m, int n) {
        final int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            final int zeroCount = calculateZeroes(s);
            final int oneCount = s.length() - zeroCount;
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(1 + dp[i - zeroCount][j - oneCount], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    private int topDown(String[] strs, int m, int n, int index, int count) {
        if (m < 0 || n < 0 || index == strs.length || (m == 0 && n == 0)) {
            return 0;
        }

        final Key key = new Key(strs.length - index - 1, m, n);

        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        final int zeroCount = calculateZeroes(strs[index]);
        final int oneCount = strs[index].length() - zeroCount;

        int max;
        if (m - zeroCount < 0 || n - oneCount < 0) {
            max = topDown(strs, m, n, index + 1, count);
        } else {
            max = Math.max(
                    topDown(strs, m, n, index + 1, count),
                    1 + topDown(strs, m - zeroCount, n - oneCount, index + 1, count));
        }

        CACHE.put(key, max);

        return max;
    }

    private int calculateZeroes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }

        return count;
    }

    private class Key {
        private int items;
        private int m;
        private int n;

        Key(int items, int m, int n) {
            this.items = items;
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key index = (Key) o;

            if (items != index.items) return false;
            if (m != index.m) return false;
            return n == index.n;
        }

        @Override
        public int hashCode() {
            int result = items;
            result = 31 * result + m;
            result = 31 * result + n;
            return result;
        }
    }
}
