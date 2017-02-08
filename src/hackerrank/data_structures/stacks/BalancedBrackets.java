package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/balanced-brackets
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            final String s = in.next();
            final Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    final char pop = stack.pop();
                    if (c == ')' && pop != '(') {
                        isBalanced = false;
                        break;
                    } else if (c == ']' && pop != '[') {
                        isBalanced = false;
                        break;
                    } else if (c == '}' && pop != '{') {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            if (isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
