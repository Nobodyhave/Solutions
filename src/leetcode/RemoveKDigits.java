package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 07/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-k-digits
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) {
            return num;
        }

        final Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        final char[] chars = new char[stack.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[chars.length - 1 - i] = stack.pop();
        }

        int idx = 0;
        while (idx < chars.length && chars[idx] == '0') {
            idx++;
        }

        return idx == chars.length ? "0" : new String(chars, idx, chars.length - idx);
    }
}
