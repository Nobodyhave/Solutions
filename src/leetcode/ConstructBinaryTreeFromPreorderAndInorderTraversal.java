package leetcode;

/**
 * Created by Aleksandr on 14/06/2017.
 * Project Solutions
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(0, 0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode constructTree(int preStart, int start, int end, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || start > end) {
            return null;
        }

        final TreeNode root = new TreeNode(preorder[preStart]);
        final int mid = findIndex(inorder, start, end, root.val);

        root.left = constructTree(preStart + 1, start, mid - 1, preorder, inorder);
        root.right = constructTree(preStart + mid - start + 1, mid + 1, end, preorder, inorder);
        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }

        return -1;
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
