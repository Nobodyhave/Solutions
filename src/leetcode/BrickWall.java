package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/brick-wall
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0 || wall.get(0) == null || wall.get(0).size() == 0) {
            return 0;
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> brickRow : wall) {
            int length = 0;
            for (int j = 0; j < brickRow.size() - 1; j++) {
                length += brickRow.get(j);
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
        }

        int max = 0;
        for (Integer val : map.values()) {
            max = Math.max(max, val);
        }

        return wall.size() - max;
    }
}
