package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final PriorityQueue<Integer> leftHeap = new PriorityQueue<>(new ReverseComparator());
        final PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            final int num = in.nextInt();

            if (leftHeap.isEmpty()) {
                leftHeap.add(num);
            } else if (leftHeap.size() == rightHeap.size()) {
                if (num <= leftHeap.peek()) {
                    leftHeap.add(num);
                } else {
                    rightHeap.add(num);
                    leftHeap.add(rightHeap.poll());
                }
            } else {
                if (num > leftHeap.peek()) {
                    rightHeap.add(num);
                } else {
                    leftHeap.add(num);
                    rightHeap.add(leftHeap.poll());
                }
            }

            if (i % 2 == 0) {
                System.out.format("%.1f\n", (double) leftHeap.peek());
            } else {
                System.out.format("%.1f\n", (leftHeap.peek() + rightHeap.peek()) / 2.0);
            }
        }
    }

    private static class ReverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    }
}

