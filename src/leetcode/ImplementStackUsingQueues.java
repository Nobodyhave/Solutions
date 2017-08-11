package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/implement-stack-using-queues
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        } else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.isEmpty() ? q2.poll() : q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.size() + q2.size() == 0;
    }
}
