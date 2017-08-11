package leetcode;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/number-of-islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        final int rows = grid.length, cols = grid[0].length;
        final UnionFind uf = new UnionFind(rows * cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != rows - 1 && grid[i][j] == '1' && grid[i + 1][j] == '1') {
                    uf.union(i * cols + j, (i + 1) * cols + j);
                }
                if (j != cols - 1 && grid[i][j] == '1' && grid[i][j + 1] == '1') {
                    uf.union(i * cols + j, i * cols + j + 1);
                }
            }
        }

        int islands = 0;
        for (int i = 0; i < uf.sizes.length; i++) {
            if (uf.sizes[i] > 1) {
                islands++;
            } else if (uf.sizes[i] == 1 && grid[i / cols][i % cols] == '1') {
                islands++;
            }
        }

        return islands;
    }

    private static class UnionFind {
        private int[] id;
        private int[] sizes;

        UnionFind(int size) {
            id = new int[size];
            sizes = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
                sizes[i] = 1;
            }
        }

        void union(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);

            if (pRoot == qRoot) {
                return;
            }

            if (sizes[pRoot] <= sizes[qRoot]) {
                id[qRoot] = pRoot;
                sizes[pRoot] += sizes[qRoot];
                sizes[qRoot] = 0;
            } else {
                id[pRoot] = qRoot;
                sizes[qRoot] += sizes[pRoot];
                sizes[pRoot] = 0;
            }
        }

        boolean connected(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);

            return pRoot == qRoot;
        }

        private int root(int p) {
            while (p != id[p]) {
                p = id[p];
            }

            return p;
        }
    }
}
