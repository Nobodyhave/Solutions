package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 22/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/zuma-game
 */
public class ZumaGame {
    private final Map<String, Integer> CACHE = new HashMap<>();

    public int findMinStep(String table, String handS) {
        if (table == null || table.length() == 0 || handS == null) {
            return 0;
        }

        final Hand hand = new Hand();
        for (int i = 0; i < handS.length(); i++) {
            hand.putBalls(handS.charAt(i), 1);
        }

        String collapsed = collapseTable(table);
        if (hand.isEmpty() && collapsed.length() > 0) {
            return -1;
        }

        int count = dfs(table + "#", hand, 0);

        return count != Integer.MAX_VALUE ? count : -1;
    }

    private String collapseTable(String table) {
        final StringBuilder sb = new StringBuilder(table);
        boolean isCollapsed;
        do {
            isCollapsed = false;
            int start = 0, end;
            for (end = 1; start < sb.length() && end < sb.length(); end++) {
                if (sb.charAt(start) != sb.charAt(end)) {
                    if (end - start >= 3) {
                        sb.delete(start, end);
                        start = Math.max(start - 1, 0);
                        while (start - 1 >= 0 && sb.charAt(start - 1) == sb.charAt(start)) {
                            start--;
                        }
                        end = start;
                        isCollapsed = true;
                    } else {
                        start = end;
                    }
                }
            }
            if (end - start >= 3) {
                sb.delete(start, end);
                isCollapsed = true;
            }
        } while (isCollapsed);

        return sb.toString();
    }

    private int dfs(String table, Hand hand, int usedBalls) {
        if (table.equals("#")) {
            return usedBalls;
        } else if (hand.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        String key = table + "|" + hand.getKey();
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < table.length(); ++j) {
            if (table.charAt(j) == table.charAt(i) && j != table.length() - 1) continue;
            int ballsToPut = 3 - (j != i ? j - i : 1);
            if (hand.getBallCount(table.charAt(i)) >= ballsToPut) {
                hand.removeBalls(table.charAt(i), ballsToPut);
                String newTable = collapseTable(table.substring(0, i) + table.substring(j));
                min = Math.min(min, dfs(newTable, hand, usedBalls + ballsToPut));
                hand.putBalls(table.charAt(i), ballsToPut);
            }
            i = j;
        }

        CACHE.put(key, min);

        return min;
    }

    private static class Hand {
        private Map<Character, Integer> balls = new TreeMap<>();
        private int count;

        String getKey() {
            StringBuilder key = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : balls.entrySet()) {
                key.append(entry.getKey()).append(entry.getValue());
            }
            return key.toString();
        }

        boolean isEmpty() {
            return count == 0;
        }

        int getBallCount(char ball) {
            return balls.getOrDefault(ball, 0);
        }

        void removeBalls(Character ball, int count) {
            balls.put(ball, balls.get(ball) - count);
            this.count -= count;
        }

        void putBalls(Character ball, int count) {
            balls.put(ball, balls.getOrDefault(ball, 0) + count);
            this.count += count;
        }
    }
}
