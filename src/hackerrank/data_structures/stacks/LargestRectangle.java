package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/largest-rectangle
 */
public class LargestRectangle {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();

        final Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        final int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }
        int i = 0;
        while (i < H.length) {
            if (stack.isEmpty() || H[i] >= H[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                final int ind = stack.pop();
                final int h = H[ind];
                final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                final int area = h * (w);
                //System.out.println("h=" + h + " widht=" + w + " area=" + area);
                if (area > max) {
                    max = area;
                }
            }
        }

        //System.out.println(max);


        while (!stack.isEmpty()) {
            final int ind = stack.pop();
            final int h = H[ind];
            final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            final int area = h * (w);
            //System.out.println("h=" + h + " widht=" + w + " area=" + area);
            if (area > max) {
                max = area;
            }
        }

        System.out.println(max);
    }
}
