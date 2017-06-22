package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;

/**
 * Created by Aleksandr on 14/06/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome
 */
public class TransformToPalindrome {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();
        final int m = in.nextInt();

        final UnionFind uf = new UnionFind(n+1);

        for (int i = 0; i < k; i++) {
            final int x = in.nextInt();
            final int y = in.nextInt();
            uf.union(x, y);
        }
        final int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(longestPalindromicSubsequence(nums, uf));
    }

    private static int longestPalindromicSubsequence(int[] nums, UnionFind uf) {
        final int n = nums.length;
        int i, j, cl;
        final int dp[][] = new int[n][n];

        for (i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (uf.connected(nums[i], nums[j]) && cl == 2) {
                    dp[i][j] = 2;
                } else if (uf.connected(nums[i], nums[j])) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int N) {
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
            while (p != parent[p]) {
                p = parent[p];
            }

            return p;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) return;

            // Make smaller root point to larger one
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
