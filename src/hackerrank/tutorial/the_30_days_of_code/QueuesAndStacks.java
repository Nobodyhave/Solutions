package hackerrank.tutorial.the_30_days_of_code;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 08/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-queues-stacks
 */
public class QueuesAndStacks {

    private Stack<Character> stack = new Stack<>();
    private Queue<Character> queue = new java.util.LinkedList<>();

    public void pushCharacter(char c) {
        stack.push(c);
    }

    public char popCharacter() {
        return stack.pop();
    }

    public void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    public char dequeueCharacter() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        QueuesAndStacks p = new QueuesAndStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }
}
