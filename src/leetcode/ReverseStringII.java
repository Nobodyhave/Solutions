package leetcode;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reverse-string-ii
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k <= 0) {
            return s;
        }

        final char[] str = s.toCharArray();
        for (int start = 0, end = k - 1; start < str.length; start += 2 * k, end += 2 * k) {
            reverse(str, start, end);
        }

        return new String(str);
    }

    private void reverse(char[] a, int start, int end) {
        if (end >= a.length) {
            end = a.length - 1;
        }

        while (start < end) {
            final char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
