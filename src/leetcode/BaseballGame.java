package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aleksandr on 30/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/baseball-game
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }

        final Deque<Integer> deque = new ArrayDeque<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                final Integer num = deque.pollFirst();
                final Integer res = deque.peek() + num;
                deque.addFirst(num);
                deque.addFirst(res);
            } else if ("D".equals(op)) {
                deque.addFirst(deque.peek() * 2);
            } else if ("C".equals(op)) {
                deque.pollFirst();
            } else {
                deque.addFirst(Integer.parseInt(op));
            }
        }

        int result = 0;
        for (int num : deque) {
            result += num;
        }

        return result;
    }
}
