package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 28/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/palindrome-partitioning
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        final List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        goDeeper(result, new ArrayList<>(), s, 0);

        return result;
    }

    private static void goDeeper(List<List<String>> result, List<String> current, String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                goDeeper(result, current, s, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
