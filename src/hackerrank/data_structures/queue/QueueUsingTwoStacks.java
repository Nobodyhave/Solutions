package hackerrank.data_structures.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int Q = scanner.nextInt();
        final Stack<Integer> push = new Stack<>();
        final Stack<Integer> pop = new Stack<>();
        for (int i = 0; i < Q; i++) {
            final int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                push.push(x);
            } else if (type == 2) {
                if (pop.isEmpty()) {
                    while (!push.isEmpty()) {
                        pop.push(push.pop());
                    }
                }
                pop.pop();
            } else if (type == 3) {
                if (pop.isEmpty()) {
                    while (!push.isEmpty()) {
                        pop.push(push.pop());
                    }
                }
                System.out.println(pop.peek());
            }
        }
    }
}
