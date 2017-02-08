package hackerrank.data_structures.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/qheap1
 */
public class QHeap1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int Q = scanner.nextInt();
        final PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < Q; i++) {
            final int type = scanner.nextInt();

            if (type == 1) {
                final int num = scanner.nextInt();
                heap.add(num);
            } else if (type == 2) {
                final int num = scanner.nextInt();
                heap.remove(num);
            } else if (type == 3) {
                System.out.println(heap.peek());
            }
        }
    }
}
