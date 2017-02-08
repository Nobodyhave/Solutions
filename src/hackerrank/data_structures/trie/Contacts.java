package hackerrank.data_structures.trie;

import java.util.Scanner;

/**
 * Created by Aleksandr on 08/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/contacts
 */
public class Contacts {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            final String type = scanner.next();

            if ("add".equals(type)) {
                String contact = scanner.next();
                trie.add(contact);
            } else if ("find".equals(type)) {
                String pref = scanner.next();
                System.out.println(trie.find(pref));
            }
        }
    }

    private static class Trie {
        private Node root = new Node();

        public void add(String contact) {
            Node node = root;
            for (int i = 0; i < contact.length(); i++) {
                char c = contact.charAt(i);

                if (node.R[c - 'a'] == null) {
                    node.R[c - 'a'] = new Node();
                }
                node.count++;
                node = node.R[c - 'a'];
            }
            node.count = 1;
            node.isKey = true;
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
