package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 13/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence
 */
public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        final Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                final long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                final int d = (int) diff;
                final int c1 = map[i].getOrDefault(d, 0);
                final int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }
}
