package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aleksandr on 29/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return -1;
        } else if (strs.length == 1) {
            return strs[0].length();
        }

        Arrays.sort(strs, new StringComparator());

        for (int i = strs.length - 1; i >= 0; i--) {
            if (i == 0 || !strs[i].equals(strs[i - 1])) {
                boolean isGood = true;

                for (int j = i + 1; j < strs.length; j++) {
                    if (isSubsequence(strs[j], strs[i])) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) {
                    return strs[i].length();
                }
            } else {
                i--;
            }
        }

        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int result = Integer.compare(s1.length(), s2.length());

            if (result == 0) {
                result = s1.compareTo(s2);
            }

            return result;
        }
    }
}
