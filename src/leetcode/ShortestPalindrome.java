package leetcode;

/**
 * Created by Aleksandr on 13/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/shortest-palindrome
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }

        if (j == s.length()) {
            return s;
        }

        final String suffix = s.substring(j);

        return new StringBuilder(suffix).reverse().append(shortestPalindrome(s.substring(0, j))).append(suffix).toString();
    }
}
