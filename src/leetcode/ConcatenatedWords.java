package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 20/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/concatenated-words
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final List<String> result = new ArrayList<>();
        if (words == null || words.length < 3) {
            return result;
        }

        final Trie trie = new Trie();
        for (String word : words) {
            if (!word.isEmpty()) {
                trie.addWord(word);
            }
        }

        for (String word : words) {
            if (!word.isEmpty() && trie.testWord(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private static class Trie {
        private TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TrieNode();
                }
                node = node.nodes[c - 'a'];
            }
            node.word = word;
        }

        boolean testWord(String word) {
            return testWord(word, 0, 0);
        }

        private boolean testWord(String word, int index, int count) {
            TrieNode node = root;

            for (int i = index; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.nodes[c - 'a'] == null) {
                    return false;
                }
                if (node.nodes[c - 'a'].word != null) {
                    if (i == word.length() - 1) { // no next word, so test count to get result.
                        return count >= 1;
                    }
                    if (testWord(word, i + 1, count + 1)) {
                        return true;
                    }
                }
                node = node.nodes[c - 'a'];
            }

            return false;
        }

        private static class TrieNode {
            private TrieNode[] nodes = new TrieNode[26];
            private String word;
        }
    }
}
