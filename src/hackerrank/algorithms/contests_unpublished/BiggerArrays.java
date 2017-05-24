package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/05/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack49/challenges/bigger-arrays
 */
public class BiggerArrays {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.nextInt();
        final int Q = in.nextInt();
        final int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        final SegmentTree segmentTree = new SegmentTree(A);
        for (int q = 0; q < Q; q++) {
            final int t = in.nextInt();
            final int start = in.nextInt() - 1;
            final int end = in.nextInt() - 1;

            if (t == 1) {
                final int x = in.nextInt();
                segmentTree.lazyUpdate(start, end, x);
            } else {
                System.out.println(F(segmentTree, start, end));
            }
        }
    }

    private static long F(SegmentTree segmentTree, int start, int end) {
        return (segmentTree.rangeProductQuery(start, end) - segmentTree.rangeProductMinusOneQuery(start, end) + MOD) % MOD;
    }

    private static class SegmentTree {
        private int[] input;
        private long[] vS;
        private long[] vS1;
        private long[] lazyValues;

        SegmentTree(int[] input) {
            this.input = input;
            final int segTreeSize = (int) Math.pow(2, (int) Math.ceil(Math.log(input.length) / Math.log(2))) * 2 - 1;
            vS = new long[segTreeSize];
            vS1 = new long[segTreeSize];
            createSegmentTree(0, input.length - 1, 0); //low,high,present
            lazyValues = new long[segTreeSize];
        }

        private void createSegmentTree(int low, int high, int present) {
            if (low == high) {
                // Create leaf
                vS[present] = input[low];
                vS1[present] = input[low] - 1;
            } else {
                final int mid = (high + low) / 2;
                // Create left subtree
                createSegmentTree(low, mid, present * 2 + 1);
                // Create right subtree
                createSegmentTree(mid + 1, high, present * 2 + 2);
                // Get current product
                vS[present] = (vS[present * 2 + 1] * vS[present * 2 + 2]) % MOD;
                vS1[present] = (vS1[present * 2 + 1] * vS1[present * 2 + 2]) % MOD;
            }
        }

        long rangeProductQuery(int low, int high) {
            return rangeProductQuery(0, input.length - 1, low, high, 0);
        }

        private long rangeProductQuery(int low, int high, int qLow, int qHigh, int present) {
            if (qHigh < low || qLow > high) { // No overlap
                return 1;
            }
            if (lazyValues[present] != 0) { // This node needs to be updated
                vS[present] = binPow(lazyValues[present], high - low + 1); // Update it
                vS1[present] = binPow(lazyValues[present] - 1, high - low + 1); // Update it
                if (low != high) { // If not leaf
                    // Mark left child as lazy
                    lazyValues[present * 2 + 1] = lazyValues[present];
                    // Mark right child as lazy
                    lazyValues[present * 2 + 2] = lazyValues[present];
                }
                // Reset lazy value
                lazyValues[present] = 0;
            }
            // Full or over overlapping
            if (low >= qLow && high <= qHigh) {
                return vS[present];
            }
            final int mid = (low + high) / 2;

            // Return product of subtrees
            return (rangeProductQuery(low, mid, qLow, qHigh, present * 2 + 1) *
                    rangeProductQuery(mid + 1, high, qLow, qHigh, present * 2 + 2)) % MOD;
        }

        long rangeProductMinusOneQuery(int low, int high) {
            return rangeProductMinusOneQuery(0, input.length - 1, low, high, 0);
        }

        private long rangeProductMinusOneQuery(int low, int high, int qLow, int qHigh, int present) {
            if (qHigh < low || qLow > high) { // No overlap
                return 1;
            }
            if (lazyValues[present] != 0) { // This node needs to be updated
                vS[present] = binPow(lazyValues[present], high - low + 1); // Update it
                vS1[present] = binPow(lazyValues[present] - 1, high - low + 1); // Update it
                if (low != high) { // If not leaf
                    // Mark left child as lazy
                    lazyValues[present * 2 + 1] = lazyValues[present];
                    // Mark right child as lazy
                    lazyValues[present * 2 + 2] = lazyValues[present];
                }
                // Reset lazy value
                lazyValues[present] = 0;
            }
            // Full or over overlapping
            if (low >= qLow && high <= qHigh) {
                return vS1[present];
            }
            final int mid = (low + high) / 2;

            // Return product of subtrees
            return (rangeProductMinusOneQuery(low, mid, qLow, qHigh, present * 2 + 1) *
                    rangeProductMinusOneQuery(mid + 1, high, qLow, qHigh, present * 2 + 2)) % MOD;
        }

        void lazyUpdate(int low, int high, int x) {
            lazyUpdate(0, input.length - 1, low, high, 0, x);
        }

        private long binPow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) > 0)
                    res = res * a % MOD;
                b >>= 1;
                a = a * a % MOD;
            }
            return res % MOD;
        }

        private void lazyUpdate(int low, int high, int qLow, int qHigh, int current, int val) {
            // If the node is not updated.
            if (lazyValues[current] != 0) {
                // Update it
                vS[current] = binPow(lazyValues[current], high - low + 1);
                vS1[current] = binPow(lazyValues[current] - 1, high - low + 1);
                // If not leaf
                if (low != high) {
                    // Mark left child as lazy
                    lazyValues[current * 2 + 1] = lazyValues[current];
                    // Mark right child as lazy
                    lazyValues[current * 2 + 2] = lazyValues[current];
                }
                // Reset lazy value
                lazyValues[current] = 0;
            }
            if (qLow > high || qHigh < low) {
                // Current segment is not within range [l, r]
            } else if (qLow <= low && qHigh >= high) { // Segment is fully within range
                vS[current] = binPow(val, high - low + 1);
                vS1[current] = binPow(val - 1, high - low + 1);
                // Not leaf node
                if (high != low) {
                    // Mark left child as lazy
                    lazyValues[current * 2 + 1] = val;
                    // Mark right child as lazy
                    lazyValues[current * 2 + 2] = val;
                }
            } else { // Segment is particularly in the range
                final int mid = (low + high) / 2;
                // Updating left child
                lazyUpdate(low, mid, qLow, qHigh, current * 2 + 1, val);
                // Updating right child
                lazyUpdate(mid + 1, high, qLow, qHigh, current * 2 + 2, val);
                // Updating root with product
                vS[current] = (vS[current * 2 + 1] * vS[current * 2 + 2]) % MOD;
                vS1[current] = (vS1[current * 2 + 1] * vS1[current * 2 + 2]) % MOD;
            }
        }
    }
}
