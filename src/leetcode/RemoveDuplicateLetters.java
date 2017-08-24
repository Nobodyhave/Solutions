package leetcode;

/**
 * Created by Aleksandr on 17/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-duplicate-letters
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int position = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(position)) {
                position = i;
            }
            if (--count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(position) + removeDuplicateLetters(s.substring(position + 1).replaceAll("" + s.charAt(position), ""));
    }
}
