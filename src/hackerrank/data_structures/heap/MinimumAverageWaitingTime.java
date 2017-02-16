package hackerrank.data_structures.heap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/minimum-average-waiting-time
 */
public class MinimumAverageWaitingTime {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final PriorityQueue<Customer> startPq = new PriorityQueue<>((c1, c2) -> Long.compare(c1.start, c2.start));
        final PriorityQueue<Customer> endPq = new PriorityQueue<>((c1, c2) -> Long.compare(c1.duration, c2.duration));

        for (int i = 0; i < N; i++) {
            startPq.add(new Customer(in.nextInt(), in.nextInt()));
        }

        long ticks = 0;
        long time = 0;
        while (!startPq.isEmpty() || !endPq.isEmpty()) {
            while (!startPq.isEmpty() && startPq.peek().start <= ticks) {
                endPq.add(startPq.poll());
            }

            if (endPq.isEmpty()) {
                ticks += 1;
            } else {
                final Customer customer = endPq.poll();
                time += ticks - customer.start + customer.duration;
                ticks += customer.duration;
            }
        }

        System.out.println(time / N);
    }

    private static class Customer {
        private long start;
        private long end;
        private long duration;

        public Customer(int start, int duration) {
            this.start = start;
            this.duration = duration;
            this.end = start + duration;
        }
    }
}
