package hackerrank.algorithms.contests_unpublished;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 03/04/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/contests/hourrank-19/challenges/what-are-the-odds
 */
public class WhatAreOdds {
    public static void main(String[] args) throws FileNotFoundException {
        //final InputReader in = new InputReader(System.in);
        final InputReader in = new InputReader(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int n = in.readInt();
        final int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.readInt();
        }

        final Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

        int xor = 0;
        long count = 0;
        TreeMap<Integer, Integer> set;
        for (int i = 0; i < n; i++) {
            set = map.computeIfAbsent(xor, k -> new TreeMap<>());
            set.put(i, set.isEmpty() ? 1 : set.lastEntry().getValue() + 1);

            xor ^= s[i];
        }

        xor = 0;
        for (int i = n-1; i >= 0; i--) {
            set = map.get(xor);
            if (set != null) {
                Integer floorKey = set.floorKey(i);
                if (floorKey != null) {
                    Integer less = set.get(floorKey);
                    count += less != null ? less : 0;
                }
            }
            xor ^= s[i];
        }

        System.out.println(count);
    }

    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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
