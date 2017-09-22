package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 05/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/4sum
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }

        final Map<Integer, Integer> AB = new HashMap<>();
        final Map<Integer, Integer> CD = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                final int ab = a + b;
                AB.put(ab, AB.getOrDefault(ab, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                final int cd = c + d;
                CD.put(cd, CD.getOrDefault(cd, 0) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : AB.entrySet()) {
            int sum = entry.getKey();
            int count = entry.getValue();

            if (CD.containsKey(-sum)) {
                result += CD.get(-sum) * count;
            }
        }

        return result;
    }
}
