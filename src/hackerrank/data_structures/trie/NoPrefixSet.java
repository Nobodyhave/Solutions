package hackerrank.data_structures.trie;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/no-prefix-set
 */
public class NoPrefixSet {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();

        final Trie trie = new Trie();
        boolean badSet = false;
        for (int i = 0; i < N; i++) {
            final String str = in.next();

            if (!trie.add(str)) {
                badSet = true;
                System.out.println("BAD SET");
                System.out.println(str);
                break;
            }
        }

        if (!badSet) {
            System.out.println("GOOD SET");
        }
    }

    private static class Trie {
        private Node root = new Node();

        public boolean add(String contact) {
            Node node = root;
            for (int i = 0; i < contact.length(); i++) {
                char c = contact.charAt(i);

                if (node.R[c - 'a'] == null) {
                    node.R[c - 'a'] = new Node();
                } else if (node.R[c - 'a'].isKey) {
                    return false;
                } else if (i == contact.length() - 1) {
                    for (Node next : node.R) {
                        if (next != null) {
                            return false;
                        }
                    }
                }
                node.count++;
                node = node.R[c - 'a'];
            }
            node.count = 1;
            node.isKey = true;

            return true;
        }

        public int find(String pref) {
            Node node = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                node = node.R[c - 'a'];
                if (node == null) {
                    break;
                }
            }

            if (node == null) {
                return 0;
            } else {
                return node.count;
            }
        }

        private static class Node {
            Node[] R = new Node[26];
            boolean isKey;
            int count;
        }
    }
}
