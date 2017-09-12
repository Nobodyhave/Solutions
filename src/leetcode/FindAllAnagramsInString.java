package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        final Map<Character, Integer> sCount = new HashMap<>();
        final Map<Character, Integer> pCount = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int start = 0, end = 0; end < s.length(); end++) {
            sCount.put(s.charAt(end), sCount.getOrDefault(s.charAt(end), 0) + 1);
            if (end - start == p.length() - 1) {
                boolean isAnagram = true;
                for (Map.Entry<Character, Integer> pEntry : pCount.entrySet()) {
                    if (!Objects.equals(pEntry.getValue(), sCount.getOrDefault(pEntry.getKey(), -1))) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    result.add(start);
                }
                sCount.put(s.charAt(start), sCount.get(s.charAt(start)) - 1);
                start++;
            }
        }

        return result;
    }
}
