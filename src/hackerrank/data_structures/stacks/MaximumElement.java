package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/maximum-element
 */
public class MaximumElement {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Stack<Integer> stack = new Stack<>();
        final Stack<Integer> max = new Stack<>();
        final int N = scanner.nextInt();
        for (int n = 0; n < N; n++) {
            final int cmd = scanner.nextInt();
            if (cmd == 1) {
                final int x = scanner.nextInt();
                stack.push(x);
                if (max.isEmpty()) {
                    max.push(x);
                } else {
                    if (x > max.peek()) {
                        max.push(x);
                    } else {
                        max.push(max.peek());
                    }
                }
            } else if (cmd == 2) {
                stack.pop();
                max.pop();
            } else {
                System.out.println(max.peek());
            }
        }
    }
}
