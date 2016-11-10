package hackerrank.algorithms.implementation;

/**
 * Created by Aleksandr on 09/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/larrys-array
 */

import java.util.Scanner;

public class LarrysArray {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int n = in.nextInt();
            final int[] a = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                a[i] = in.nextInt();
            }

            FenwickTree bit = new FenwickTree((int) Math.pow(10, 7) + 1);
            long count = 0;
            for (int i = 0; i < n; i++) {
                bit.update(a[i], 1);
                count += bit.getSum(a[i] - 1);
            }

            if (n % 2 != 0) {
                if (count % 2 != 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                if (count % 2 != 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }

    private static class FenwickTree {
        private long[] binaryIndexedTree;

        public FenwickTree(int size) {
            binaryIndexedTree = new long[size];
        }

        public void update(int index, long val) {
            while (index < binaryIndexedTree.length) {
                binaryIndexedTree[index] += val;
                index = getNext(index);
            }
        }

        public long getSum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += binaryIndexedTree[index];
                index = getParent(index);
            }
            return sum;
        }

        private int getParent(int index) {
            return index - (index & -index);
        }

        private int getNext(int index) {
            return index + (index & -index);
        }
    }
}
