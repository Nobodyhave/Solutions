package leetcode;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/redundant-connection
 */
public class RedundantConnectionI {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        final UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                return edge;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }

        return new int[0];
    }

    private static class UnionFind {
        private int[] id;
        private int[] size;

        UnionFind(int size) {
            this.id = new int[size];
            this.size = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
                this.size[i] = 1;
            }
        }

        boolean isConnected(int u, int v) {
            final int rootU = root(u);
            final int rootV = root(v);

            return rootU == rootV;
        }

        void union(int u, int v) {
            final int rootU = root(u);
            final int rootV = root(v);

            if (rootU == rootV) {
                return;
            }

            if (size[rootU] >= size[rootV]) {
                id[rootV] = id[rootU];
                size[rootU] += size[rootV];
            } else {
                id[rootU] = id[rootV];
                size[rootV] += size[rootU];
            }
        }

        private int root(int u) {
            int parent = u;
            while (id[parent] != parent) {
                parent = id[parent];
            }

            while (id[u] != parent) {
                int temp = id[u];
                id[u] = parent;
                u = temp;
            }

            return parent;
        }
    }
}
