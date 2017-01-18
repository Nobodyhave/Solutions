package hackerrank.algorithms.contests_unpublished;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aleksandr on 12/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w28/challenges/value-of-friendship
 */
public class TheValueOfFriendship {
    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int Q = in.nextInt();
        for (int q = 0; q < Q; q++) {
            final int N = in.nextInt();
            int M = in.nextInt();

            final WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N + 1);
            for (int m = 0; m < M; m++) {
                int x = in.nextInt();
                int y = in.nextInt();

                uf.union(x, y);
            }

            for (int i = 1; i <= N; i++) {
                if (uf.size[i] != 1 && uf.parent[i] != i) {
                    uf.size[i] = 1;
                }
            }

            final int[] sizes = new int[N + 1];
            System.arraycopy(uf.size, 0, sizes, 0, N + 1);
            Arrays.sort(sizes);

            long links = 0;
            long totalSum = 0;
            long curSum = 0;
            for (int i = N; i > 0; i--) {
                if (sizes[i] != 1) {
                    links += sizes[i] - 1;
                    final long n = sizes[i] - 1;
                    final long sum = n * (n + 1) * (n + 2) / 3 + curSum * n;
                    curSum += n * (n + 1);
                    totalSum += sum;
                } else {
                    break;
                }
            }

            totalSum += curSum * (M - links);
            System.out.println(totalSum);
        }
    }

    private static class WeightedQuickUnionUF {
        private int[] parent;   // parent[i] = parent of i
        private int[] size;     // size[i] = number of sites in subtree rooted at i
        private int count;      // number of components

        public WeightedQuickUnionUF(int N) {
            count = N;
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            validate(p);
            while (p != parent[p])
                p = parent[p];
            return p;
        }

        private void validate(int p) {
            int N = parent.length;
            if (p < 0 || p >= N) {
                throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N - 1));
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
