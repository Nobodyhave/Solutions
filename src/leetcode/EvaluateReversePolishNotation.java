package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        final Deque<Integer> operands = new LinkedList<>();

        for (final String token : tokens) {
            if ("+".equals(token)) {
                operands.add(operands.pollLast() + operands.pollLast());
            } else if ("-".equals(token)) {
                int second = operands.pollLast();
                operands.add(operands.pollLast() - second);
            } else if ("/".equals(token)) {
                int second = operands.pollLast();
                operands.add(operands.pollLast() / second);
            } else if ("*".equals(token)) {
                operands.add(operands.pollLast() * operands.pollLast());
            } else {
                operands.add(Integer.parseInt(token));
            }
        }

        return operands.pollLast();
    }
}
