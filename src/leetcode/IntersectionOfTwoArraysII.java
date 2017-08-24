package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final List<Integer> resultList = new ArrayList<>();
        for (Integer num : nums2) {
            if (map.containsKey(num)) {
                resultList.add(num);
                map.computeIfPresent(num, (key, value) -> value != 1 ? value - 1 : null);
            }
        }

        final int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
