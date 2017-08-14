package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/remove-invalid-parentheses
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        final Queue<String> queue = new LinkedList<>();
        final Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        int found = -1;
        while (!queue.isEmpty()) {
            String candidate = queue.poll();

            if (isValid(candidate)) {
                if (found == -1) {
                    found = candidate.length();
                }
                if (found == candidate.length()) {
                    result.add(candidate);
                }
            }

            if (found != -1) {
                continue;
            }

            for (int i = 0; i < candidate.length(); i++) {
                if (candidate.charAt(i) == '(' || candidate.charAt(i) == ')') {
                    String newCandidate = candidate.substring(0, i) + candidate.substring(i + 1, candidate.length());
                    if (!visited.contains(newCandidate)) {
                        queue.add(newCandidate);
                        visited.add(newCandidate);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
