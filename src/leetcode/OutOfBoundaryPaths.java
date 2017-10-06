package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/out-of-boundary-paths
 */
public class OutOfBoundaryPaths {
    private final Map<Key, Integer> CACHE = new HashMap<>();

    public int findPaths(int m, int n, int N, int i, int j) {
        if (m == 0 || n == 0 || N == 0) {
            return 0;
        }

        return dfs(m, n, i, j, N);
    }

    private int dfs(int m, int n, int row, int col, int count) {
        if (count == 0) {
            return 0;
        }
        final Key key = new Key(row, col, count);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        int paths = 0;
        paths += row == 0 ? 1 : 0;
        paths += row == m - 1 ? 1 : 0;
        paths += col == 0 ? 1 : 0;
        paths += col == n - 1 ? 1 : 0;
        if (row != 0) {
            paths += dfs(m, n, row - 1, col, count - 1);
            paths %= 1000000007;
        }
        if (row != m - 1) {
            paths += dfs(m, n, row + 1, col, count - 1);
            paths %= 1000000007;
        }
        if (col != 0) {
            paths += dfs(m, n, row, col - 1, count - 1);
            paths %= 1000000007;
        }
        if (col != n - 1) {
            paths += dfs(m, n, row, col + 1, count - 1);
            paths %= 1000000007;
        }

        paths %= 1000000007;

        CACHE.put(key, paths);

        return paths;
    }

    private static class Key {
        private int row;
        private int col;
        private int count;

        Key(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (row != key.row) return false;
            if (col != key.col) return false;
            return count == key.count;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            result = 31 * result + count;
            return result;
        }
    }
}
