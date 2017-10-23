package leetcode;

import java.util.List;

/**
 * Created by Aleksandr on 20/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/replace-words
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict.isEmpty() || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        final Trie trie = new Trie();
        for (String root : dict) {
            trie.add(root);
        }

        final String[] split = sentence.split(" ");
        final StringBuilder sb = new StringBuilder();
        for (String word : split) {
            final String root = trie.getRoot(word);
            if (root == null) {
                sb.append(word);
            } else {
                sb.append(root);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static class Trie {
        private TrieNode root = new TrieNode();

        public void add(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }

            node.root = word;
        }

        private String getRoot(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return null;
                } else if (node.children[c - 'a'].root != null) {
                    return node.children[c - 'a'].root;
                }
                node = node.children[c - 'a'];
            }

            return node.root;
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
            private String root;
        }
    }
}
