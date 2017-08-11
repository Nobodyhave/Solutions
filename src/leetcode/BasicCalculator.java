package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 17/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/basic-calculator
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final String str = s.replaceAll(" ", "");
        final Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (c == '(') {
                stack.add("(");
            } else if (c == '+') {
                stack.add("+");
            } else if (c == '-') {
                stack.add("-");
            } else if (c >= '0' && c <= '9') {
                final StringBuilder sb = new StringBuilder();
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                    i++;
                }
                stack.add(sb.toString());
                i--;
            } else if (c == ')') {
                final Deque<String> operation = new LinkedList<>();
                while (!stack.isEmpty()) {
                    String item = stack.pollLast();
                    if (item.equals("(")) {
                        int result = Integer.parseInt(operation.pollFirst());
                        while (!operation.isEmpty()) {
                            if (operation.pollFirst().equals("+")) {
                                result += Integer.parseInt(operation.pollFirst());
                            } else {
                                result -= Integer.parseInt(operation.pollFirst());
                            }
                        }
                        stack.add(String.valueOf(result));
                        break;
                    } else {
                        operation.addFirst(item);
                    }
                }
            }
        }

        final Deque<String> operation = new LinkedList<>();

        while (!stack.isEmpty()) {
            operation.addFirst(stack.pollLast());
        }

        int result = Integer.parseInt(operation.pollFirst());
        while (!operation.isEmpty()) {
            if (operation.pollFirst().equals("+")) {
                result += Integer.parseInt(operation.pollFirst());
            } else {
                result -= Integer.parseInt(operation.pollFirst());
            }
        }
        stack.add(String.valueOf(result));

        return Integer.parseInt(stack.pollFirst());
    }
}
