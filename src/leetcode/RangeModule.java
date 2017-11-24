package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 14/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/range-module
 */
public class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) {
            return;
        }
        final Integer start = map.floorKey(left);
        final Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else if (start != null && map.get(start) >= left) {
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
        } else {
            map.put(left, Math.max(map.get(end), right));
        }

        final Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        final Set<Integer> set = new HashSet<>(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        final Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if (right <= left) {
            return;
        }
        final Integer start = map.floorKey(left);
        final Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }

        final Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        final Set<Integer> set = new HashSet<>(subMap.keySet());
        map.keySet().removeAll(set);
    }
}
