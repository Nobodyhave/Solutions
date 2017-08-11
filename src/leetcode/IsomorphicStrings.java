package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 12/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/isomorphic-strings
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        final Map<Character, Character> map1 = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            } else {
                if (map1.get(s.charAt(i)) == null || map1.get(s.charAt(i)) != t.charAt(i) || map2.get(t.charAt(i)) == null || s.charAt(i) != map2.get(t.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
