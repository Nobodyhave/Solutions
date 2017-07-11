package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 10/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/repeated-dna-sequences
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        final Set<String> result = new HashSet<>();

        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        final Map<String, List<Integer>> map = new HashMap<>();
        for (int start = 0; start <= s.length() - 10; start++) {
            final String str = s.substring(start, start + 10);
            List<Integer> list = map.computeIfAbsent(str, k -> new ArrayList<>());
            list.add(start);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                /*int prev = entry.getValue().get(0), count = 1;
                for (int i = 1; i < entry.getValue().size(); i++) {
                    if (entry.getValue().get(i) >= prev + 10) {
                        prev = entry.getValue().get(i);
                        count++;
                    }
                }
                if (count >= 2) {
                    result.add(entry.getKey());
                }*/
                result.add(entry.getKey());
            }
        }

        return new ArrayList<>(result);
    }
}
