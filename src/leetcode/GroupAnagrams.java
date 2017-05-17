package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 16/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        final Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sorted = sortString(str);
            final List<String> list = map.computeIfAbsent(sorted, k -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String sortString(String s) {
        final char[] letters = s.toCharArray();
        Arrays.sort(letters);

        return new String(letters);
    }
}
