package leetcode;

import java.util.Stack;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popStack.isEmpty()) {
            moveStack();
        }

        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popStack.isEmpty()) {
            moveStack();
        }

        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.size() + popStack.size() <= 0;
    }

    private void moveStack() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
