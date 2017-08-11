package leetcode;

/**
 * Created by Aleksandr on 13/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree
 */
public class ImplementTriePrefixTree {
    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(node.nodes[c] == null) {
                node.nodes[c] = new TrieNode();
            }
            node = node.nodes[c];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(node.nodes[c] == null) {
                return false;
            }
            node = node.nodes[c];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(node.nodes[c] == null) {
                return false;
            }
            node = node.nodes[c];
        }

        for(TrieNode child : node.nodes) {
            if(child != null) {
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
