package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 30/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/first-unique-character-in-a-string
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
