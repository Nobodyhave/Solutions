package hackerrank.data_structures.trees;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/tree-huffman-decoding
 */
public class TreeHuffmanDecoding {
    void decode(String S, Node root) {
        Node start = root;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '0') {
                start = start.left;
            } else {
                start = start.right;
            }

            if (start.left == null && start.right == null) {
                System.out.print(start.data);
                start = root;
            }
        }
    }

    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }
}
