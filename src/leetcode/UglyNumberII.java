package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Aleksandr on 10/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/ugly-number-ii/description/
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        final PriorityQueue<Long> pq = new PriorityQueue<>();

        pq.add(1L);

        long last = 0;
        for (int i = 0; i < n; i++) {
            long current = pq.poll();

            if (last != current) {
                last = current;
                pq.add(current * 2);
                pq.add(current * 3);
                pq.add(current * 5);
            } else {
                i--;
            }
        }

        return (int) last;
    }
}
