package leetcode;

/**
 * Created by Aleksandr on 13/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/add-and-search-word-data-structure-design
 */
public class AddAndSearchWordDataStructureDesign {
    private TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWordDataStructureDesign() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int start) {
        if (node == null) {
            return false;
        } else if (start == word.length()) {
            return node.isWord;
        }

        if (word.charAt(start) != '.') {
            return search(node.nodes[word.charAt(start) - 'a'], word, start + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                boolean isFound = search(node.nodes[i], word, start + 1);
                if (isFound) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];
        private boolean isWord;
    }
}
