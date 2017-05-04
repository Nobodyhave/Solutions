package leetcode;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        final int[] count = new int[256];

        int start = 0, end = 1, size = Integer.MIN_VALUE;
        count[s.charAt(0)]++;
        while (end < s.length() && start < end) {
            char cE = s.charAt(end);
            if (count[cE] != 0) {
                while (start < end) {
                    char cS = s.charAt(start);
                    count[cS]--;
                    start++;
                    if (count[cE] == 0) {
                        break;
                    }
                }
            }
            count[cE]++;
            end++;
            if (end - start > size) {
                size = end - start;
            }
        }

        return size;
    }
}
