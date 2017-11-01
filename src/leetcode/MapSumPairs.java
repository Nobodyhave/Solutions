package leetcode;

/**
 * Created by Aleksandr on 27/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/map-sum-pairs
 */
public class MapSumPairs {
    private final Trie trie = new Trie();

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.getSum(prefix);
    }

    private static class Trie {
        private TrieNode root = new TrieNode(0, false);

        int getSum(String key) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                node = node.children[key.charAt(i) - 'a'];

                if (node == null) {
                    return 0;
                }
            }

            return -node.count;
        }

        void insert(String key, int val) {
            insert(key, val, root, 0);
        }

        private int insert(String key, int val, TrieNode root, int depth) {
            if (depth == key.length()) {
                if (!root.isWord) {
                    root.isWord = true;
                    root.val = val;
                    root.count += val;

                    return val;
                } else {
                    int diff = root.val - val;
                    root.val = val;
                    root.count += diff;

                    return diff;
                }
            }

            final char c = key.charAt(depth);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode(0, false);
            }

            int diff = insert(key, val, root.children[c - 'a'], depth + 1);
            root.count += diff;

            return diff;
        }

        private static class TrieNode {
            private int count = 0;
            private int val;
            private boolean isWord;
            private TrieNode[] children = new TrieNode[26];

            TrieNode(int val, boolean isWord) {
                this.val = val;
                this.isWord = true;
            }
        }
    }
}
