package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 02/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/gray-code
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        final List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}
