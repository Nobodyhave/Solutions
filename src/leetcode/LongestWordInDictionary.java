package leetcode;

/**
 * Created by Aleksandr on 15/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/longest-word-in-dictionary
 */
public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        final Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        return trie.getLongestBuildableWord();
    }

    private static class Trie {
        private TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }

            node.word = word;
        }

        String getLongestBuildableWord() {
            return getLongestBuildableWord(root);
        }

        private String getLongestBuildableWord(TrieNode root) {
            if (root != this.root && (root == null || root.word == null)) {
                return "";
            }

            String max = root.word != null ? root.word : "";
            for (TrieNode child : root.children) {
                final String childWord = getLongestBuildableWord(child);
                if (childWord.length() > max.length()) {
                    max = childWord;
                }
            }

            return max;
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
            private String word;
        }
    }
}
