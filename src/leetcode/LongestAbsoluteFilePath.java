package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 30/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-absolute-file-path
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            final int lev = s.lastIndexOf("\t") + 1;
            while (lev + 1 < stack.size()) {
                stack.pop();
            }
            final int len = stack.peek() + s.length() - lev + 1;
            stack.push(len);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}
