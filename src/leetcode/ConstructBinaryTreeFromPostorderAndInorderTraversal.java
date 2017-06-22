package leetcode;

import java.util.HashMap;

/**
 * Created by Aleksandr on 14/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    public TreeNode buildTreePostIn(int[] inorder, int[] postOrder) {
        if (inorder == null || postOrder == null || inorder.length != postOrder.length) {
            return null;
        }
        final HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postOrder, 0, postOrder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postOrder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }
        final TreeNode root = new TreeNode(postOrder[pe]);
        final int ri = hm.get(postOrder[pe]);
        final TreeNode leftChild = buildTreePostIn(inorder, is, ri - 1, postOrder, ps, ps + ri - is - 1, hm);
        final TreeNode rightChild = buildTreePostIn(inorder, ri + 1, ie, postOrder, ps + ri - is, pe - 1, hm);
        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
