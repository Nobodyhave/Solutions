package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Aleksandr on 10/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/insertion-sort
 */
public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for(int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int[] nums = new int[N];
            for(int i = N-1; i >= 0; i--) {
                nums[i] = in.nextInt();
            }

            final FenwickTree bit = new FenwickTree((int)Math.pow(10,7) + 1);
            long count = 0;
            for(int i = 0; i < N; i++) {
                bit.update(nums[i], 1);
                //System.out.println("i: " + i + " val: " + (nums[i]-1) + " sum: " + bit.getSum(nums[i]-1));
                count += bit.getSum(nums[i]-1);
            }

            System.out.println(count);
        }
    }

    private static class FenwickTree {
        private long[] binaryIndexedTree;

        public FenwickTree(int size) {
            binaryIndexedTree = new long[size];
        }

        public void update(int index, long val){
            while(index < binaryIndexedTree.length){
                //System.out.println("Update index: " + index);
                binaryIndexedTree[index] += val;
                index = getNext(index);
            }
        }

        public long getSum(int index){
            //index = index + 1;
            int sum = 0;
            while(index > 0){
                //System.out.println("Read index: " + index);
                sum += binaryIndexedTree[index];
                index = getParent(index);
            }
            return sum;
        }

        private int getParent(int index){
            return index - (index & -index);
        }

        private int getNext(int index){
            return index + (index & -index);
        }
    }
}
