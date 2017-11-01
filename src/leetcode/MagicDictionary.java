package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 27/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/implement-magic-dictionary
 */
public class MagicDictionary {
    private final Set<String> dictionary = new HashSet<>();

    public MagicDictionary() {

    }

    public void buildDict(String[] dict) {
        for (String s : dict) {
            final char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < 26; j++) {
                    final char c = (char) ('a' + j);
                    if (chars[i] == c) {
                        continue;
                    }
                    char old = chars[i];
                    chars[i] = c;
                    dictionary.add(new String(chars));
                    chars[i] = old;
                }
            }
        }
    }

    public boolean search(String word) {
        return dictionary.contains(word);
    }
}
