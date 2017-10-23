package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Aleksandr on 20/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/dota2-senate
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) {
            return "";
        }

        Queue<Integer> curD = new ArrayDeque<>();
        Queue<Integer> nextD = new ArrayDeque<>();
        Queue<Integer> curR = new ArrayDeque<>();
        Queue<Integer> nextR = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                curD.add(i);
            } else {
                curR.add(i);
            }
        }

        while (true) {
            if (!curD.isEmpty() && !curR.isEmpty()) {
                if (curD.peek() < curR.peek()) {
                    nextD.add(curD.poll());
                    curR.poll();
                } else {
                    nextR.add(curR.poll());
                    curD.poll();
                }
            } else if (!curD.isEmpty()) {
                if (!nextR.isEmpty()) {
                    nextD.add(curD.poll());
                    nextR.poll();
                } else {
                    return "Dire";
                }
            } else if (!curR.isEmpty()) {
                if (!nextD.isEmpty()) {
                    nextR.add(curR.poll());
                    nextD.poll();
                } else {
                    return "Radiant";
                }
            } else {
                Queue<Integer> temp = curR;
                curR = nextR;
                nextR = temp;

                temp = curD;
                curD = nextD;
                nextD = temp;
            }
        }
    }
}
