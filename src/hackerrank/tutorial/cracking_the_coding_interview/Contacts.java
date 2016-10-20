package hackerrank.tutorial.cracking_the_coding_interview;

/**
 * Created by Aleksandr on 20/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/ctci-contacts
 */

import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            final String op = in.next();
            final String contact = in.next();

            if ("add".equals(op)) {
                trie.add(contact);
            } else if ("find".equals(op)) {
                System.out.println(trie.childCount(contact));
            } else {
                throw new IllegalArgumentException("Unsupported operation");
            }
        }
    }

    private static class Trie {
        private static final int ALPHABET_SIZE = 26;
        private Node root = new Node();

        public void add(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new Node();
                }
                node.nodes[c - 'a'].childCount++;
                node = node.nodes[c - 'a'];
            }
            node.isWord = true;
        }

        public int childCount(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.nodes[c - 'a'] == null) {
                    return 0;
                }
                node = node.nodes[c - 'a'];
            }

            return node.childCount;
        }

        private static class Node {
            private Node[] nodes = new Node[ALPHABET_SIZE];
            private boolean isWord;
            private int childCount = 0;
        }
    }
}

