package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/integer-replacement
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n < 1) {
            return 0;
        }

        final PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long) n);

        while (true) {
            long pair = pq.poll();
            long steps = pair >> 32;
            long num = pair & 0xFFFFFFFFL;

            if (num == 1) {
                return (int) steps;
            }

            steps++;
            if (num % 2 == 0) {
                pq.add((steps << 32) | (num / 2));
            } else {
                pq.add((steps << 32) | (num + 1));
                pq.add((steps << 32) | (num - 1));
            }
        }
    }
}
