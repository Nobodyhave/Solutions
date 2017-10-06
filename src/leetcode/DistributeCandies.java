package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/distribute-candies
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }

        int kinds = 0, brother = 0;
        for (int count : map.values()) {
            kinds++;
            brother += count - 1;
        }

        return brother >= candies.length / 2 ? kinds : kinds - Math.abs(brother - candies.length / 2);
    }
}
