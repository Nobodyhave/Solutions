package hackerrank.algorithms.contests_unpublished;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/sears-dots-arrows/challenges/balanced-subsequence
 */
public class BalancedSubsequence {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            String s = in.next();
            Stack<Character> stack = new Stack<>();
            int result = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.empty()) {
                        continue;
                    } else {
                        stack.pop();
                        result += 2;
                    }
                }
            }
            System.out.println(result);
        }

    }
}
