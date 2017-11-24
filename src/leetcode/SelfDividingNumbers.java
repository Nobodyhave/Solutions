package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 20/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/self-dividing-numbers
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        final List<Integer> result = new ArrayList<>();

        outer:
        for (int i = left; i <= right; i++) {
            final String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                final char c = s.charAt(j);
                if (c == '0' || i % (c - '0') != 0) {
                    continue outer;
                }
            }
            result.add(i);
        }

        return result;
    }
}
