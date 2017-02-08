package hackerrank.data_structures.disjoint_set;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/merging-communities
 */
public class MergingCommunities {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int Q = in.nextInt();

        final UF uf = new UF(N);
        for (int q = 0; q < Q; q++) {
            final String type = in.next();

            if ("Q".equals(type)) {
                System.out.println(uf.size(in.nextInt()));
            } else {
                uf.union(in.nextInt(), in.nextInt());
            }
        }
    }

    private static class UF {
        int[] id;
        int[] size;

        public UF(int N) {
            id = new int[N + 1];
            size = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        public void union(int v, int w) {
            int rootV = root(v);
            int rootW = root(w);

            if (rootV == rootW) {
                return;
            }

            if (size[rootV] < size[rootW]) {
                id[rootV] = rootW;
                size[rootW] += size[rootV];
            } else {
                id[rootW] = rootV;
                size[rootV] += size[rootW];
            }
        }

        public int size(int v) {
            return size[root(v)];
        }

        private int root(int v) {
            while (v != id[v]) {
                v = id[v];
            }

            return v;
        }
    }
}
