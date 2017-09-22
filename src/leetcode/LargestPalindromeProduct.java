package leetcode;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/largest-palindrome-product
 */
public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        final int upperBound = (int) Math.pow(10, n) - 1;
        final int lowerBound = upperBound / 10;

        for (int leftPart = upperBound - 1; leftPart > lowerBound; leftPart--) {
            final long assumedPalindrome = Long.valueOf(leftPart + new StringBuilder().append(leftPart).reverse().toString());
            for (long multiplier = upperBound; multiplier * multiplier >= assumedPalindrome; multiplier--) {
                if (assumedPalindrome % multiplier == 0) {
                    return (int) (assumedPalindrome % 1337);
                }
            }
        }

        return 0;
    }
}
