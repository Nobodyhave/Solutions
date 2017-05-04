package leetcode;

/**
 * Created by Aleksandr on 03/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/string-to-integer-atoi
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        final String s = str.trim();
        int index = 0;
        boolean isNegative = false;
        if (s.charAt(0) != '+' && s.charAt(0) != '-' && s.charAt(0) < '0' && s.charAt(0) > '9') {
            return 0;
        } else if (s.charAt(0) == '-') {
            isNegative = true;
            index = 1;
        } else if (s.charAt(0) == '+') {
            isNegative = false;
            index = 1;
        }

        final StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            sb.append(s.charAt(index));
            index++;
        }

        long result = 0;
        for (int i = 0; i < sb.length(); i++) {
            result *= 10;
            result += sb.charAt(i) - '0';
            if (isNegative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!isNegative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return isNegative ? -(int) result : (int) result;
    }
}
