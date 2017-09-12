package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/binary-watch
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        final List<String> result = new ArrayList<>();
        if (num < 0 || num > 10) {
            return result;
        }

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) | m) == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }
}
