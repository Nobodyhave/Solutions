package leetcode;

/**
 * Created by Aleksandr on 19/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }

        final int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
