package leetcode;

import java.util.Stack;

/**
 * Created by Aleksandr on 29/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/simplify-path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        final String[] segments = path.split("/");

        final Stack<String> stack = new Stack<>();
        for (int i = 1; i < segments.length; i++) {
            if (".".equals(segments[i]) || segments[i].isEmpty()) {
                continue;
            } else if ("..".equals(segments[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(segments[i]);
            }
        }

        final StringBuilder sb = new StringBuilder();

        if (stack.size() != 0) {
            for (String s : stack) {
                sb.append("/").append(s);
            }
        } else {
            sb.append("/");
        }

        return sb.toString();
    }
}
