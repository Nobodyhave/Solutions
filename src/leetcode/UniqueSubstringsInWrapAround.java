package leetcode;

/**
 * Created by Aleksandr on 19/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string
 */
public class UniqueSubstringsInWrapAround {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }

        final int[] lengths = new int[26];
        int curLength = 0;
        for (int i = 0; i < p.length(); i++) {
            final char cur = p.charAt(i);
            if (i > 0 && (cur == p.charAt(i - 1) + 1 || (cur == 'a' && p.charAt(i - 1) == 'z'))) {
                curLength++;
            } else {
                curLength = 1;
            }

            lengths[cur - 'a'] = Math.max(lengths[cur - 'a'], curLength);
        }

        int count = 0;
        for (int i = 0; i < lengths.length; i++) {
            count += lengths[i];
        }

        return count;
    }
}
