package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 11/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-pattern
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        final String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        final Map<Character, String> map1 = new HashMap<>();
        final Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            final Character c = pattern.charAt(i);

            if (!map1.containsKey(c) && !map2.containsKey(words[i])) {
                map1.put(c, words[i]);
                map2.put(words[i], c);
            } else if (!map1.containsKey(c) && map2.containsKey(words[i])) {
                return false;
            } else if (map1.containsKey(c) && !map2.containsKey(words[i])) {
                return false;
            } else if (map1.containsKey(c) && map2.containsKey(words[i]) && !(map1.get(c).equals(words[i]) || map2.get(words[i]).equals(c))) {
                return false;
            }
        }

        return true;
    }
}
