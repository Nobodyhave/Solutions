package hackerrank.algorithms.contests_unpublished;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Aleksandr on 15/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/rookierank-2/challenges/prefix-neighbors
 */
public class PrefixNeighbors {
    public static void main(String[] args) throws IOException {
        final InputReader in = new InputReader(System.in);
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Algos\\test_data.txt"));
        final int n = in.readInt();

        final Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i < 12; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String s = in.next();
            map.get(s.length()).add(s);
        }

        final Trie trie = new Trie();

        for (int i = 1; i < 12; i++) {
            List<String> words = map.get(i);
            words.forEach(trie::add);
        }

        System.out.println(trie.getBenefit());
    }

    public static int setBit(int a, int bit) {
        return a | (1 << bit);
    }

    public static int clearBit(int a, int bit) {
        return a & ~(1 << bit);
    }

    private static class Trie {
        private Node root = new Node();

        public void add(String word) {
            root = put(root, word, 0, 0);
        }

        public int getBenefit() {
            return getBenefit(root);
        }

        private int getBenefit(Node node) {
            int benefit = node.accepted ? node.benefit : 0;
            for (int i = 0; i < node.R.length; i++) {
                if (node.R[i] != null) {
                    benefit += getBenefit(node.R[i]);
                }
            }

            return benefit;
        }

        private Node put(Node node, String key, int d, int benefit) {
            if (node == null) {
                node = new Node();
            }
            if (d == key.length()) {
                node.isKey = true;
                node.accepted = true;
                node.benefit = benefit;
                node.key = key;
                return node;
            }
            char c = key.charAt(d);
            node.R[c - 'A'] = put(node.R[c - 'A'], key, d + 1, benefit + c);
            node.childrenAccepted = node.R[c - 'A'].accepted ?
                    setBit(node.childrenAccepted, c - 'A') : clearBit(node.childrenAccepted, c - 'A');
            if (node.isKey) {
                node.accepted = !node.R[c - 'A'].accepted && node.childrenAccepted == 0;
            } else {
                node.accepted = node.childrenAccepted != 0;
            }

            return node;
        }

        private static class Node {
            int childrenAccepted;
            boolean accepted;
            int benefit;
            Node[] R = new Node[26];
            String key;
            boolean isKey;
        }
    }

    private static class InputReader {

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
}
