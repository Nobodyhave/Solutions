package leetcode;

/**
 * Created by Aleksandr on 02/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/scramble-string
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        } else if (s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        }

        final int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }

        return false;
    }
}
