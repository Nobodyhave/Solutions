package hackerrank.java.data_structures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-stack
 */
public class JavaStack {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            final String s = in.next();

            final Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    System.out.println("false");
                    return;
                } else if (c == '}' && stack.pop() != '{') {
                    System.out.println("false");
                    return;
                } else if (c == ')' && stack.pop() != '(') {
                    System.out.println("false");
                    return;
                } else if (c == ']' && stack.pop() != '[') {
                    System.out.println("false");
                    return;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
