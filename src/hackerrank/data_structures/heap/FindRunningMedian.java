package hackerrank.data_structures.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/find-the-running-median
 */
public class FindRunningMedian {
    public static void main(String args[]) throws Exception {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();

        final PriorityQueue<Integer> left = new PriorityQueue<>((i1, i2) -> {
            return i2.compareTo(i1);
        });
        final PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            final int num = scanner.nextInt();

            if (left.size() == 0) {
                left.add(num);
            } else if (left.size() == right.size()) {
                if (num > right.peek()) {
                    left.add(right.poll());
                    right.add(num);
                } else {
                    left.add(num);
                }
            } else {
                if (num > left.peek()) {
                    right.add(num);
                } else {
                    right.add(left.poll());
                    left.add(num);
                }
            }

            if (left.size() == right.size()) {
                System.out.format("%.1f\n", (left.peek() + right.peek()) / 2.0);
            } else {
                System.out.format("%.1f\n", Double.valueOf(left.peek()));
            }
        }
    }
}
