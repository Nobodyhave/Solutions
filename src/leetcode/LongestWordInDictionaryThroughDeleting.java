package leetcode;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.size() == 0) {
            return "";
        }

        d.sort(new StringComparator());

        for (String candidate : d) {
            if (isSubsequence(s, candidate)) {
                return candidate;
            }
        }

        return "";
    }

    private boolean isSubsequence(String base, String candidate) {
        if (candidate.length() > base.length()) {
            return false;
        }

        int i = 0, j = 0;
        while (i < base.length() && j < candidate.length()) {
            if (base.charAt(i) == candidate.charAt(j)) j++;
            i++;
        }
        return j == candidate.length();
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int result = Integer.compare(s2.length(), s1.length());

            if (result == 0) {
                result = s1.compareTo(s2);
            }

            return result;
        }
    }
}
