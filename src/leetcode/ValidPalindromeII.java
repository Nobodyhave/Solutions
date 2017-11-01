package leetcode;

/**
 * Created by Aleksandr on 30/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-palindrome-ii
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }

        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s.substring(0, start) + s.substring(start + 1, s.length()))
                        || isPalindrome(s.substring(0, end) + s.substring(end + 1, s.length()));
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
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
