package leetcode;

import java.util.Stack;

/**
 * Created by Aleksandr on 08/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == '}' && stack.peek() != '{') {
                return false;
            } else if (c == ']' && stack.peek() != '[') {
                return false;
            } else if (c == ')' && stack.peek() != '(') {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
