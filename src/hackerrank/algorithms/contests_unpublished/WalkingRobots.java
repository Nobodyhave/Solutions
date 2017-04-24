package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 24/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/101hack48/challenges/walking-robots
 */
public class WalkingRobots {
    private static int howManyCollisions(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int col = 0;
        final Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            }

            if (stack.peek() == 'r' && c == 'l') {
                col += 2;
                stack.pop();
                while (!stack.isEmpty() && stack.peek() == 'r') {
                    stack.pop();
                    col++;
                }
                stack.push('d');
            } else if (stack.peek() == 'r' && c == 'd') {
                while (!stack.isEmpty() && stack.peek() == 'r') {
                    stack.pop();
                    col++;
                }
                stack.push('d');
            } else if (stack.peek() == 'r' && c == 'r') {
                stack.push('r');
            } else if (stack.peek() == 'd' && c == 'l') {
                col++;
                stack.push('d');
            } else if (stack.peek() == 'd' && c == 'd') {
                stack.push('d');
            } else if (stack.peek() == 'd' && c == 'r') {
                stack.push('r');
            } else if (stack.peek() == 'l' && c == 'l') {
                stack.push('l');
            } else if (stack.peek() == 'l' && c == 'd') {
                stack.push('d');
            } else if (stack.peek() == 'l' && c == 'r') {
                stack.push('r');
            }
        }

        return col;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            final String s = in.next();
            final int result = howManyCollisions(s);
            System.out.println(result);
        }
    }
}
