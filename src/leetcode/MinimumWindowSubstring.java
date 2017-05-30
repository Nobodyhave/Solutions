package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {
    private static int charCount = 0;

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            final char c = t.charAt(i);
            final Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
                if (count == 0) {
                    charCount++;
                }
            }
        }
        charCount = map.keySet().size();

        int start = 0, end = 1, minStart = 0, minEnd = Integer.MAX_VALUE;
        decrementMap(map, s.charAt(0));
        while (start < s.length()) {
            if (charCount <= 0) {
                if (end - start < minEnd - minStart) {
                    minEnd = end;
                    minStart = start;
                }
                if (start < s.length()) {
                    incrementMap(map, s.charAt(start));
                }
                start++;
            } else if (end < s.length()) {
                decrementMap(map, s.charAt(end));
                end++;
            } else {
                break;
            }
        }

        if (minEnd != Integer.MAX_VALUE) {
            return s.substring(minStart, minEnd);
        } else {
            return "";
        }
    }

    private static void incrementMap(Map<Character, Integer> map, char c) {
        final Integer count = map.get(c);
        if (count != null) {
            map.put(c, count + 1);
            if (count == 0) {
                charCount++;
            }
        }
    }

    private static void decrementMap(Map<Character, Integer> map, char c) {
        final Integer count = map.get(c);
        if (count != null) {
            map.put(c, count - 1);
            if (count == 1) {
                charCount--;
            }
        }
    }
}
