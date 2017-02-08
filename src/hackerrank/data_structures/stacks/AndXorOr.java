package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 07/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/and-xor-or
 */
public class AndXorOr {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }

        final Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                max = Math.max(max, a[i]^stack.peek());
                if(a[i] < stack.peek()) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(a[i]);
        }

        System.out.println(max);
        /*
        * For each int i in the array A
    while stack is nonempty
        yield (i, top of stack)
        if i is less than the top of the stack, pop the stack
        otherwise break the while loop
    push i onto stack
        * */

    }
}
