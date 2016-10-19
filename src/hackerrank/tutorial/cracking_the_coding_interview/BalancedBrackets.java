package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 19/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            final char c = expression.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final String expression = in.next();
            boolean answer = isBalanced(expression);
            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

