package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 18/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/set-mismatch
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final int[] result = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            final Integer num = map.get(i);
            if (num == null) {
                result[1] = i;
            } else if (num == 2) {
                result[0] = i;
            }
        }

        return result;
    }
}
