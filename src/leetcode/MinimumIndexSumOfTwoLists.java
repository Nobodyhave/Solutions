package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 09/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[0];
        }

        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], -i);
        }

        int min = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < list2.length; i++) {
            final String name = list2[i];
            if (map.containsKey(name)) {
                final int sum = -map.get(name) + i;
                map.put(name, sum);
                if (sum < min) {
                    count = 1;
                    min = sum;
                } else if (sum == min) {
                    count++;
                }
            }
        }

        final String[] result = new String[count];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                result[i++] = entry.getKey();
            }
        }

        return result;
    }
}
