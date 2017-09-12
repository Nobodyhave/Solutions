package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 29/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/ransom-note
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        final Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            letters.put(magazine.charAt(i), letters.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (letters.get(ransomNote.charAt(i)) == null || letters.get(ransomNote.charAt(i)) <= 0) {
                return false;
            } else {
                letters.put(ransomNote.charAt(i), letters.get(ransomNote.charAt(i)) - 1);
            }
        }

        return true;
    }
}
