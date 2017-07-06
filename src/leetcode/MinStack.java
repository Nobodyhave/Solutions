package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 06/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/min-stack
 */
public class MinStack {
    private Deque<Integer> values = new ArrayDeque<>();
    private Deque<Integer> mins = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int x) {
        if (values.isEmpty()) {
            mins.add(x);
        } else {
            mins.add(Math.min(mins.getLast(), x));
        }
        values.add(x);
    }

    public void pop() {
        values.pollLast();
        mins.pollLast();
    }

    public int top() {
        return values.getLast();
    }

    public int getMin() {
        return mins.getLast();
    }
}
