package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by Aleksandr on 17/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/exclusive-time-of-functions
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.isEmpty() || n <= 0) {
            return new int[0];
        }

        final Function[] functions = new Function[logs.size()];
        int i = 0;
        for (String log : logs) {
            final String[] split = log.split(":");
            functions[i++] = new Function(Integer.parseInt(split[0]), "start".equals(split[1]), Integer.parseInt(split[2]));
        }

        final Deque<Function> deque = new ArrayDeque<>();
        final int[] result = new int[n];
        int prevTime = 0;
        for (i = 0; i < logs.size(); i++) {
            if (deque.isEmpty() || functions[i].isStart) {
                if (!deque.isEmpty()) {
                    result[deque.peek().id] += functions[i].time - prevTime;
                }
                deque.addFirst(functions[i]);
                prevTime = functions[i].time;
            } else {
                final Function prev = deque.pollFirst();
                result[prev.id] += functions[i].time - prevTime + 1;
                prevTime = functions[i].time + 1;
            }
        }

        return result;
    }

    private static class Function {
        private int id;
        private boolean isStart;
        private int time;

        Function(int id, boolean isStart, int time) {
            this.id = id;
            this.isStart = isStart;
            this.time = time;
        }
    }
}
