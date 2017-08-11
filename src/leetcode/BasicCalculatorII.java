package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/basic-calculator-ii
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final String str = s.replaceAll(" ", "");
        final Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (c == '*') {
                stack.add("*");
            } else if (c == '+') {
                stack.add("+");
            } else if (c == '-') {
                stack.add("-");
            } else if (c == '/') {
                stack.add("/");
            } else if (c >= '0' && c <= '9') {
                final StringBuilder sb = new StringBuilder();
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                    i++;
                }
                stack.add(sb.toString());
                i--;
            }
        }

        final Deque<String> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            String item = stack.pollFirst();
            if ("+".equals(item)) {
                result.add(item);
            } else if ("-".equals(item)) {
                result.add(item);
            } else if ("*".equals(item)) {
                Integer op1 = Integer.parseInt(result.pollLast());
                Integer op2 = Integer.parseInt(stack.pollFirst());
                result.add(String.valueOf(op1 * op2));
            } else if ("/".equals(item)) {
                Integer op1 = Integer.parseInt(result.pollLast());
                Integer op2 = Integer.parseInt(stack.pollFirst());
                result.add(String.valueOf(op1 / op2));
            } else {
                result.add(item);
            }
        }

        final Deque<String> finalResult = new LinkedList<>();
        while (!result.isEmpty()) {
            String item = result.pollFirst();
            if ("+".equals(item)) {
                Integer op1 = Integer.parseInt(finalResult.pollLast());
                Integer op2 = Integer.parseInt(result.pollFirst());
                finalResult.add(String.valueOf(op1 + op2));
            } else if ("-".equals(item)) {
                Integer op1 = Integer.parseInt(finalResult.pollLast());
                Integer op2 = Integer.parseInt(result.pollFirst());
                finalResult.add(String.valueOf(op1 - op2));
            } else {
                finalResult.add(item);
            }
        }

        return Integer.parseInt(finalResult.pollFirst());
    }
}
