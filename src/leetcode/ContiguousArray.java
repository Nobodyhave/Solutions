package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 02/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/contiguous-array
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.putIfAbsent(sum, i);
            }
        }

        return max;
    }
}
