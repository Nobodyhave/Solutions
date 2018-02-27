package codechef;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 10/01/2018.
 * Project Solutions
 * <p>
 * https://www.codechef.com/JAN18/problems/KILLKTH
 */
public class KilljeeAndKthLetter {
    private static void generateTest() throws IOException {
        final FileWriter fw = new FileWriter("C:\\Projects\\Solutions\\src\\tests.txt");
        final Random rand = new Random();

        final int N = 2000;//(int) Math.pow(2, 17) + 1;
        //fw.append(String.valueOf(N));
        //fw.append("\n");

        for (int i = 0; i < N; i++) {
            char h = (char) ('a' + rand.nextInt(26));
            fw.append(String.valueOf(h));
            //fw.append(" ");
        }
        fw.append("\n");

        final int Q = 25000;//(int) Math.pow(2, 18) + 1;
        fw.append(String.valueOf(Q));
        fw.append("\n");
        for (int q = 0; q < Q; q++) {
            int P = rand.nextInt(1000000000) + 1;
            int M = 1000000000;//rand.nextInt(1000000000) + 1;
            fw.append(String.valueOf(P));
            fw.append(" ");
            fw.append(String.valueOf(M));
            fw.append("\n");
        }

        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        generateTest();
        //final InputReader in = new InputReader(System.in);
        long t1 = System.currentTimeMillis();
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        //brute(in);
        clever(in);
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }

    private static void clever(InputReader in) {
        long t1 = System.currentTimeMillis();
        final String S = in.next();
        final Trie trie = new Trie(S);

        for (int i = 0; i < S.length(); i++) {
            trie.addWords(i);
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Generate trie: " + (t2 - t1));

        trie.traverse();

        long t3 = System.currentTimeMillis();
        System.out.println("Traverse trie: " + (t3 - t2));

        long G = 0;
        final StringBuilder sb = new StringBuilder();
        final int Q = in.readInt();
        for (int q = 0; q < Q; q++) {
            final long P = in.readInt();
            final long M = in.readInt();
            final int K = (int) ((P * G) % M) + 1;
            final char c = trie.charAt(K);
            G += c;
            sb.append(c).append('\n');
        }
        System.out.println(sb.toString());
        long t4 = System.currentTimeMillis();
        System.out.println("Process queries: " + (t4 - t3));
    }

    private static class Trie {
        private String word;
        private int sum;
        private final TreeMap<Integer, TrieNode> map = new TreeMap<>();
        private TrieNode root = new TrieNode();

        Trie(String word) {
            this.word = word;
        }

        void traverse() {
            sum = 0;
            traverse(root);
        }

        void traverse(TrieNode node) {
            for (TrieNode child : node.children) {
                if (child != null) {
                    sum += child.length * child.count;
                    map.put(sum, child);
                    traverse(child);
                }
            }
        }

        char charAt(int i) {
            final Map.Entry<Integer, TrieNode> floorEntry = map.lowerEntry(i);
            final int floorVal = (floorEntry != null ? floorEntry.getKey() : 0);
            final TrieNode ceil = map.ceilingEntry(i).getValue();
            return word.charAt((i - floorVal - 1) % ceil.length + ceil.start);
            //return charAt(i, 0, root);
        }

        char charAt(int i, int prevSum, TrieNode node) {
            int sum = prevSum;
            for (TrieNode child : node.children) {
                if (child == null) continue;

                if (sum + child.count * child.length >= i) {
                    return word.charAt((i - sum - 1) % child.length + child.start);
                } else if (sum + child.charCount() >= i) {
                    return charAt(i, sum + child.count * child.length, child);
                } else {
                    sum += child.charCount();
                }
            }

            throw new IllegalStateException("Should not happen");
        }

        void addWords(int offset) {
            addWords(offset, root);
        }

        void addWords(int offset, TrieNode node) {
            /*if (i == word.length()) {
                return i - offset;
            }*/

            for (int j = offset; j < word.length(); j++) {
                final char c = word.charAt(j);
                final int d = word.length() - j;
                node.sum += (d + 1) * d >> 2;
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.start = offset;
                node.length = j - offset + 1;
                node.count++;
            }


            //return node.length + increment;
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
            private int start;
            private int length;
            private int sum;
            private int count;

            private int charCount() {
                return sum + count * length;
            }
        }
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}
