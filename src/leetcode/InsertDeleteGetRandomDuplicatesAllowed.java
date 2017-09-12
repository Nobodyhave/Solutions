package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 28/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;

    public InsertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);

        map.computeIfAbsent(val, (key) -> new LinkedHashSet<>());
        map.get(val).add(list.size());
        list.add(val);

        return result;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < list.size() - 1) {
            int temp = list.get(list.size() - 1);
            list.set(loc, temp);
            map.get(temp).remove(list.size() - 1);
            map.get(temp).add(loc);
        }
        list.remove(list.size() - 1);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
