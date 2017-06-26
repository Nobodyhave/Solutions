package leetcode;

/**
 * Created by Aleksandr on 26/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-palindrome
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        s = s.toLowerCase();

        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
                start++;
            }

            while (end >= 0 && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
                end--;
            }

            if (start >= s.length() || end < 0) {
                break;
            } else if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
