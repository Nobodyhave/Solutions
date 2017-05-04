package leetcode;

/**
 * Created by Aleksandr on 03/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/palindrome-number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }

        long n = x;
        long rev = 0;
        while (x > 0) {
            long dig = x % 10;
            rev = rev * 10 + dig;
            x = x / 10;
        }

        return n == rev;
    }
}
