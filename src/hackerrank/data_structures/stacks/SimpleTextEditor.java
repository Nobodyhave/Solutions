package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/simple-text-editor
 */
public class SimpleTextEditor {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int Q = scanner.nextInt();

        final Stack<Operation> stack = new Stack<>();
        final StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            final int type = scanner.nextInt();

            if (type == 1) {
                final String app = scanner.next();
                stack.push(new Operation(1, app));
                sb.append(app);
            } else if (type == 2) {
                final int delCount = scanner.nextInt();
                final int start = sb.length() - delCount;
                final int end = sb.length();
                stack.push(new Operation(2, sb.substring(start, end)));
                sb.delete(start, end);
            } else if (type == 3) {
                final int k = scanner.nextInt();
                System.out.println(sb.charAt(k - 1));
            } else if (type == 4) {
                final Operation operation = stack.pop();
                if (operation.type == 1) {
                    final int start = sb.length() - operation.str.length();
                    final int end = sb.length();
                    sb.delete(start, end);
                } else if (operation.type == 2) {
                    sb.append(operation.str);
                }
            }
        }
    }

    private static class Operation {
        private int type;
        private String str;

        public Operation(int type, String str) {
            this.type = type;
            this.str = str;
        }
    }
}
