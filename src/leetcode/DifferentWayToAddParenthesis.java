package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksandr on 20/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/different-ways-to-add-parentheses
 */
public class DifferentWayToAddParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if (op == '-' || op == '*' || op == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (op) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
