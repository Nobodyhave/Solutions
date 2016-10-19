package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 19/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 */

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if (stackOldestOnTop.isEmpty()) {
                copyStacks();
            }

            if (stackOldestOnTop.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return stackOldestOnTop.peek();
            }
        }

        public T dequeue() {
            if (stackOldestOnTop.isEmpty()) {
                copyStacks();
            }

            if (stackOldestOnTop.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return stackOldestOnTop.pop();
            }
        }

        private void copyStacks() {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        final MyQueue<Integer> queue = new MyQueue<Integer>();

        final Scanner scan = new Scanner(System.in);
        final int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            final int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

