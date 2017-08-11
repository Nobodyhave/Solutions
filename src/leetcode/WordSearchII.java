package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 30/05/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/word-search
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        final Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        final Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                final StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                goDeeper(board, new boolean[board.length][board[0].length], result, trie, sb, i, j);
            }
        }

        return new ArrayList<>(result);
    }

    private static boolean goDeeper(char[][] board, boolean[][] marked, Set<String> result, Trie words, StringBuilder sb, int row, int col) {
        marked[row][col] = true;
        boolean found = makeMove(board, marked, result, words, sb, row - 1, col);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, result, words, sb, row + 1, col);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, result, words, sb, row, col - 1);
        if (found) {
            return true;
        }
        found = makeMove(board, marked, result, words, sb, row, col + 1);
        if (found) {
            return true;
        }
        marked[row][col] = false;

        return false;
    }

    private static boolean makeMove(char[][] board, boolean[][] marked, Set<String> result, Trie words, StringBuilder sb, int row, int col) {
        if (words.search(sb)) {
            result.add(sb.toString());
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || marked[row][col] || !words.startsWith(sb)) {
            return false;
        }

        sb.append(board[row][col]);
        final boolean found = goDeeper(board, marked, result, words, sb, row, col);
        sb.deleteCharAt(sb.length() - 1);

        return found;
    }

    private static class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.nodes[c] == null) {
                    node.nodes[c] = new TrieNode();
                }
                node = node.nodes[c];
            }
            node.isWord = true;
        }

        public boolean search(StringBuilder word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.nodes[c] == null) {
                    return false;
                }
                node = node.nodes[c];
            }
            return node.isWord;
        }

        boolean startsWith(StringBuilder prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int c = prefix.charAt(i) - 'a';
                if (node.nodes[c] == null) {
                    return false;
                }
                node = node.nodes[c];
            }

            for (TrieNode child : node.nodes) {
                if (child != null) {
                    return true;
                }
            }

            return node.isWord;
        }

        private static class TrieNode {
            private TrieNode[] nodes = new TrieNode[26];
            private boolean isWord;
        }
    }
}
