package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/intersection-of-two-arrays
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        final Set<Integer> set = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        final List<Integer> resultList = new ArrayList<>();
        for (Integer num : nums2) {
            if (set.contains(num)) {
                resultList.add(num);
                set.remove(num);
            }
        }

        final int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
