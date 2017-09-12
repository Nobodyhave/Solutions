package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-palindrome
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        int length = 0;
        for (Integer count : map.values()) {
            if ((count & 1) == 0) {
                length += count;
            } else {
                length += count - 1;
                odd = 1;
            }
        }

        return length + odd;
    }
}
