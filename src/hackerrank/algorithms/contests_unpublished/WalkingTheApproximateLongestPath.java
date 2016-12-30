package hackerrank.algorithms.contests_unpublished;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Aleksandr on 30/12/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/university-codesprint/challenges/walking-the-approximate-longest-path
 */
public class WalkingTheApproximateLongestPath {
    public static void main(String[] args) {
        final InputReader in = new InputReader(System.in);

        final int n = in.readInt();
        final int m = in.readInt();

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            final int v = in.readInt() - 1;
            final int w = in.readInt() - 1;
            graph.addEdge(v, w);
            graph.addEdge(w, v);
        }

        LongestPath lp = new LongestPath(graph);

        System.out.println(lp.longestPath.size());
        for (int i = 0; i < n; i++) {
            System.out.print((lp.longestPath.get(i) + 1) + " ");
        }
    }

    private static class Graph {
        private List<Integer>[] vertices;
        private int size;

        public Graph(int size) {
            this.size = size;
            vertices = (List<Integer>[]) new ArrayList[size];

            for (int i = 0; i < size; i++) {
                vertices[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            vertices[v].add(w);
            vertices[w].add(v);
        }

        public int size() {
            return size;
        }

        public List<Integer> adj(int v) {
            return vertices[v];
        }
    }

    private static class LongestPath {
        private List<Integer> longestPath = new ArrayList<>();
        private List<Integer>[] paths;

        public LongestPath(Graph graph) {
            int size = Math.min(825, graph.size);
            paths = (List<Integer>[]) new ArrayList[size];
            for (int i = 0; i < size; i++) {
                paths[i] = new DFS(graph, i).longestPath;
            }

            int maxPath = Integer.MIN_VALUE;
            int ind = 0;
            for (int i = 0; i < paths.length; i++) {
                if (paths[i].size() > maxPath) {
                    maxPath = paths[i].size();
                    ind = i;
                }
            }

            longestPath = paths[ind];
        }
    }

    private static class DFS {
        private boolean[] marked;
        private List<Integer> longestPath = new ArrayList<>();

        public DFS(Graph graph, int start) {
            marked = new boolean[graph.size];

            marked[start] = true;
            List<Integer> path = new ArrayList<>();
            path.add(start);
            dfs(graph, start, path);
        }

        private void dfs(Graph graph, int start, List<Integer> path) {
            graph.adj(start).stream().filter(w -> !marked[w]).forEach(w -> {
                marked[w] = true;
                path.add(w);
                dfs(graph, w, path);
                if (path.size() > longestPath.size()) {
                    longestPath = new ArrayList<>(path);
                }
                path.remove(path.size() - 1);
            });
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}
