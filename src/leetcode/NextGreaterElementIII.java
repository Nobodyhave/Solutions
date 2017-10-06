package leetcode;

import java.util.Arrays;

/**
 * Created by Aleksandr on 04/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/next-greater-element-iii
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        final char[] digits = String.valueOf(n).toCharArray();

        if (isLastPermutation(digits)) {
            return -1;
        }
        int left = 0;
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                left = i;
            }
        }

        int right = digits.length - 1;
        for (int i = right; i > 0; i--) {
            if (digits[i] > digits[left]) {
                right = i;
                break;
            }
        }

        final char temp = digits[left];
        digits[left] = digits[right];
        digits[right] = temp;

        Arrays.sort(digits, left + 1, digits.length);

        long result = Long.parseLong(new String(digits));

        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }

    private boolean isLastPermutation(char[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i - 1] < digits[i]) {
                return false;
            }
        }

        return true;
    }
}
