package interviewbit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/all-unique-permutations/
 */
public class AllUniquePermutations {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private final Map<Integer, Integer> counts = new LinkedHashMap<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return result;
        }

        for (Integer num : a) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        permute(counts, new ArrayList<>(), 0, a.size());

        return result;
    }

    private void permute(Map<Integer, Integer> counts, ArrayList<Integer> list, int start, int remaining) {
        if (remaining == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (start == counts.size()) {
            return;
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (i < start) {
                continue;
            }

            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                permute(counts, list, start + 1, remaining);
            } else {
                entry.setValue(count - 1);
                list.add(num);
                permute(counts, list, start, remaining - 1);
                list.remove(list.size() - 1);
                entry.setValue(count);
            }
        }
    }
}
