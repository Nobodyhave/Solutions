package leetcode;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        return preorder(t);
    }

    private String preorder(TreeNode root) {
        if (root == null) {
            return "";
        }
        String pL = preorder(root.left);
        String pR = preorder(root.right);

        if (pL.isEmpty() && pR.isEmpty()) {
            return String.valueOf(root.val);
        } else if (!pL.isEmpty() && pR.isEmpty()) {
            return root.val + "(" + pL + ")";
        } else if (pL.isEmpty()) {
            return root.val + "()" + "(" + pR + ")";
        } else {
            return root.val + "(" + pL + ")" + "(" + pR + ")";
        }
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
