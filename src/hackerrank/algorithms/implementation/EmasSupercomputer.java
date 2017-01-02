package hackerrank.algorithms.implementation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 02/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/two-pluses
 */
public class EmasSupercomputer {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        final int M = in.nextInt();

        final boolean[][] cells = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            final String row = in.next();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'G') {
                    cells[i][j] = true;
                }
            }
        }

        final PriorityQueue<Cross> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cells[i][j]) {
                    int size = 1;
                    final Cross cross = new Cross(j, i, size);
                    pq.add(new Cross(j, i, size));
                    while (cross.isExpandable(cells)) {
                        size++;
                        cross.incrementSize();
                        pq.add(new Cross(j, i, size));
                    }
                }
            }
        }

        final List<Cross> list = new ArrayList<>();

        list.add(pq.poll());
        int result = 1;

        while (!pq.isEmpty()) {
            final Cross cur = pq.poll();

            for (Cross cross : list) {
                if (cur.notIntersects(cross)) {
                    result = Math.max(result, (cur.size * 4 - 3) * (cross.size * 4 - 3));
                }
            }
            list.add(cur);
        }

        System.out.println(result);
    }

    private static class Cross implements Comparable<Cross> {
        int x;
        int y;
        int size = 1;

        public Cross(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public int compareTo(Cross o) {
            int result = o.size - size;

            if (result == 0) {
                result = y - o.y;
            }

            if (result == 0) {
                result = x - o.x;
            }

            return result;
        }

        public void incrementSize() {
            size++;
        }

        public boolean isExpandable(boolean[][] cells) {
            return x - size >= 0 && cells[y][x - size] &&
                    x + size < cells[0].length && cells[y][x + size] &&
                    y - size >= 0 && cells[y - size][x] &&
                    y + size < cells.length && cells[y + size][x];
        }

        public boolean notIntersects(Cross o) {
            boolean result;
            if (x < o.x) {
                if (y < o.y) {
                    if (o.x - x >= Math.max(size, o.size)) {
                        result = true;
                    } else if (o.y - y >= Math.max(size, o.size)) {
                        result = true;
                    } else {
                        result = (x + size - 1) < o.x && (y + size - 1) < o.y;
                    }
                } else if (y == o.y) {
                    result = (x + size - 1) < (o.x - size + 1);
                } else {
                    if (o.x - x >= Math.max(size, o.size)) {
                        result = true;
                    } else if (y - o.y >= Math.max(size, o.size)) {
                        result = true;
                    } else {
                        result = (x + size - 1) < o.x && (y - size + 1) > o.y;
                    }
                }
            } else if (x == o.x) {
                if (y < o.y) {
                    result = (y - size + 1) > (o.y + size - 1);
                } else if (y == o.y) {
                    result = false;
                } else {
                    result = (y + size - 1) < (o.y - size + 1);
                }
            } else {
                if (y < o.y) {
                    if (x - o.x >= Math.max(size, o.size)) {
                        result = true;
                    } else if (o.y - y >= Math.max(size, o.size)) {
                        result = true;
                    } else {
                        result = (x - size + 1) > o.x && (y + size - 1) < o.y;
                    }
                } else if (y == o.y) {
                    result = (x - size + 1) > (o.x + size - 1);
                } else {
                    if (x - o.x >= Math.max(size, o.size)) {
                        result = true;
                    } else if (y - o.y >= Math.max(size, o.size)) {
                        result = true;
                    } else {
                        result = (x - size + 1) > o.x && (y - size + 1) > o.y;
                    }
                }
            }

            return result;
        }
    }
}
