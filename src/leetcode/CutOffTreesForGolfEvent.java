package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 27/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/cut-off-trees-for-golf-event
 */
public class CutOffTreesForGolfEvent {
    private final int[][] MOVES = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty() || forest.get(0) == null || forest.get(0).size() == 0) {
            return 0;
        } else if (forest.get(0).get(0) == 0) {
            return -1;
        }

        final int rows = forest.size();
        final int cols = forest.get(0).size();
        final PriorityQueue<Tree> pq = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            final List<Integer> row = forest.get(i);
            for (int j = 0; j < cols; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new Tree(i, j, row.get(j)));
                }
            }
        }

        Tree current = (pq.peek().height == forest.get(0).get(0)) ? pq.poll() : new Tree(0, 0, 1);
        int steps = 0;
        while (!pq.isEmpty()) {
            final Tree next = pq.poll();
            final int dist = getDistance(forest, rows, cols, current.row, current.col, next.row, next.col);
            if (dist == -1) {
                break;
            } else {
                steps += dist;
            }
            current = next;
        }

        return pq.isEmpty() ? steps : -1;
    }

    private int getDistance(List<List<Integer>> forest, int rows, int cols, int startR, int startC, int endR, int endC) {
        final boolean[] marked = new boolean[rows * cols];
        final int[] dist = new int[rows * cols];
        final Queue<Integer> queue = new ArrayDeque<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(startR * cols + startC);
        marked[startR * cols + startC] = true;
        dist[startR * cols + startC] = 0;
        while (!queue.isEmpty()) {
            final int index = queue.poll();
            final int r = index / cols;
            final int c = index % cols;

            for (int[] move : MOVES) {
                int nextR = r + move[0];
                int nextC = c + move[1];

                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols
                        && !marked[nextR * cols + nextC] && forest.get(nextR).get(nextC) != 0) {
                    marked[nextR * cols + nextC] = true;
                    dist[nextR * cols + nextC] = dist[r * cols + c] + 1;
                    if (nextR == endR && nextC == endC) {
                        return dist[nextR * cols + nextC];
                    } else {
                        queue.add(nextR * cols + nextC);
                    }
                }
            }
        }

        return -1;
    }

    private static class Tree implements Comparable<Tree> {
        private int row;
        private int col;
        private int height;

        Tree(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(height, o.height);
        }
    }
}
