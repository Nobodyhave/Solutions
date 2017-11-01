package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/knight-probability-in-chessboard
 */
public class KnightProbabilityInChessboard {
    private final static int[][] MOVES = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private final Map<Move, Double> CACHE = new HashMap<>();

    public double knightProbability(int N, int K, int r, int c) {
        return move(N, r, c, K);
    }

    private double move(int N, int r, int c, int k) {
        if (k == 0) {
            if (r >= 0 && r < N && c >= 0 && c < N) {
                return 1.0;
            } else {
                return 0.0;
            }
        } else if (!(r >= 0 && r < N && c >= 0 && c < N)) {
            return 0.0;
        }

        final Move key = new Move(r, c, k);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }

        double sum = 0;
        for (int[] move : MOVES) {
            sum += move(N, r + move[0], c + move[1], k - 1);
        }
        sum /= 8;

        CACHE.put(key, sum);

        return sum;
    }

    private static class Move {
        private int row;
        private int col;
        private int k;

        Move(int row, int col, int k) {
            this.row = row;
            this.col = col;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Move move = (Move) o;

            return row == move.row && col == move.col && k == move.k;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            result = 31 * result + k;
            return result;
        }
    }
}
