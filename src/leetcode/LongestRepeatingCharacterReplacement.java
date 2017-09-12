package leetcode;

/**
 * Created by Aleksandr on 11/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-repeating-character-replacement
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        final int len = s.length();
        final int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
