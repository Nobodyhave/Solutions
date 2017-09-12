package leetcode;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        final int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] < min && count[i] > 0) {
                min = count[i];
                minIndex = i;
            }
        }

        if (count[minIndex] >= k) {
            return s.length();
        } else {
            char c = (char) ('a' + minIndex);
            int start = 0, max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    max = Math.max(max, longestSubstring(s.substring(start, i), k));
                    start = i + 1;
                }
            }

            return Math.max(max, longestSubstring(s.substring(start, s.length()), k));
        }
    }
}
