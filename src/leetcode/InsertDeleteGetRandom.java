package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 28/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 */
public class InsertDeleteGetRandom {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        final int index = map.get(val);
        if (index != list.size() - 1) {
            final int temp = list.get(index);
            list.set(index, list.get(list.size() - 1));
            list.set(list.size() - 1, temp);
            map.put(list.get(index), index);
        }

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
