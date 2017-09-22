package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 18/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/can-i-win
 */
public class CanIWin {
    private final Map<Integer, Boolean> CACHE = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int moves = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            moves = setBit(moves, i);
        }

        return desiredTotal == 0 || minimax(moves, maxChoosableInteger, desiredTotal, 0, true);
    }

    private boolean minimax(int moves, int maxMoves, int target, int sum, boolean first) {
        if (sum >= target) {
            return !first;
        } else if(moves == 0) {
            return false;
        }

        final int key = getCacheKey(moves, maxMoves, sum);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        for (int i = maxMoves; i >= 1; i--) {
            if (testBit(moves, i)) {
                moves = clearBit(moves, i);
                boolean isWin = minimax(moves, maxMoves, target, sum + i, !first);
                moves = setBit(moves, i);
                if (first && isWin) {
                    CACHE.put(key, true);
                    return true;
                } else if (!isWin && !first) {
                    CACHE.put(key, false);
                    return false;
                }
            }
        }
        CACHE.put(key, !first);

        return !first;
    }

    private static int getCacheKey(int moves, int maxMoves, int sum) {
        return (sum << maxMoves) | moves;
    }

    private static int clearBit(int a, int bit) {
        return a & ~(1 << bit);
    }

    private static int setBit(int a, int bit) {
        return a | (1 << bit);
    }

    private static boolean testBit(int a, int bit) {
        return (a & (1 << bit)) != 0;
    }
}
