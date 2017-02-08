package hackerrank.data_structures.arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmicCrush {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int N = in.nextInt();
        final int M = in.nextInt();

        final int[] arr = new int[N];
        Arrays.fill(arr, 0);

        final SegmentTree segmentTree = new SegmentTree(arr);
        for (int m = 0; m < M; m++) {
            segmentTree.lazyUpdate(in.nextInt() - 1, in.nextInt() - 1, in.nextInt());

        }
        System.out.println(segmentTree.rangeQuery(0, arr.length - 1));
    }

    private static class SegmentTree {
        private int[] input;
        private long[] values;
        private long[] lazyValues;

        public SegmentTree(int[] input) {
            this.input = input;
            final int segTreeSize = (int) Math.pow(2, (int) Math.ceil(Math.log(input.length) / Math.log(2))) * 2 - 1;
            values = new long[segTreeSize];
            createSegmentTree(0, input.length - 1, 0); //low,high,present
            lazyValues = new long[segTreeSize];


        }

        public void createSegmentTree(int low, int high, int present) {
            if (low == high) {
                // Create leaf
                values[present] = input[low];
            } else {
                final int mid = (high + low) / 2;
                // Create left subtree
                createSegmentTree(low, mid, present * 2 + 1);
                // Create right subtree
                createSegmentTree(mid + 1, high, present * 2 + 2);
                // Get current max
                values[present] = Math.max(values[present * 2 + 1], values[present * 2 + 2]);
            }
        }

        public long rangeQuery(int low, int high) {
            return rangeQuery(0, input.length - 1, low, high, 0);
        }

        public long rangeQuery(int low, int high, int qLow, int qHigh, int present) {
            if (qHigh < low || qLow > high) { // No overlap
                return Integer.MIN_VALUE;
            }
            if (lazyValues[present] != 0) { // This node needs to be updated
                values[present] += lazyValues[present]; // Update it
                if (low != high) { // If not leaf
                    // Mark left child as lazy
                    lazyValues[present * 2 + 1] += lazyValues[present];
                    // Mark right child as lazy
                    lazyValues[present * 2 + 2] += lazyValues[present];
                }
                // Reset lazy value
                lazyValues[present] = 0;
            }
            // Full or over overlapping
            if (low >= qLow && high <= qHigh) {
                return values[present];
            }
            final int mid = (low + high) / 2;

            // Return max of subtrees
            return Math.max(
                    // Query left subtree
                    rangeQuery(low, mid, qLow, qHigh, present * 2 + 1),
                    // Query right subtree
                    rangeQuery(mid + 1, high, qLow, qHigh, present * 2 + 2));
        }

        public void lazyUpdate(int low, int high, int x) {
            lazyUpdate(0, input.length - 1, low, high, 0, x);
        }

        public void lazyUpdate(int low, int high, int qLow, int qHigh, int current, int val) {
            // If the node is not updated.
            if (lazyValues[current] != 0) {
                // Update it
                values[current] += lazyValues[current];
                // If not leaf
                if (low != high) {
                    // Mark left child as lazy
                    lazyValues[current * 2 + 1] += lazyValues[current];
                    // Mark right child as lazy
                    lazyValues[current * 2 + 2] += lazyValues[current];
                }
                // Reset lazy value
                lazyValues[current] = 0;
            }
            if (qLow > high || qHigh < low) {
                // Current segment is not within range [l, r]
            } else if (qLow <= low && qHigh >= high) { // Segment is fully within range
                values[current] += val;
                // Not leaf node
                if (high != low) {
                    // Mark left child as lazy
                    lazyValues[current * 2 + 1] += val;
                    // Mark right child as lazy
                    lazyValues[current * 2 + 2] += val;
                }
            } else { // Segment is particularly in the range
                final int mid = (low + high) / 2;
                // Updating left child
                lazyUpdate(low, mid, qLow, qHigh, current * 2 + 1, val);
                // Updating right child
                lazyUpdate(mid + 1, high, qLow, qHigh, current * 2 + 2, val);
                // Updating root with max/sum values
                values[current] = Math.max(values[current * 2 + 1], values[current * 2 + 2]);
            }
        }
    }
}

