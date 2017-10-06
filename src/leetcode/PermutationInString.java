package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 06/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/permutation-in-string
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        } else if (s1.length() == 0) {
            return true;
        }

        final int[] counts1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts1[s1.charAt(i) - 'a']++;
        }

        final int[] counts2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(counts1, counts2)) {
                return true;
            }
            counts2[s2.charAt(i) - 'a']++;
            counts2[s2.charAt(i - s1.length()) - 'a']--;
        }

        return Arrays.equals(counts1, counts2);
    }
}
