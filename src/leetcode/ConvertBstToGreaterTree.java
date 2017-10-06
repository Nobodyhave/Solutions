package leetcode;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/convert-bst-to-greater-tree
 */
public class ConvertBstToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);

        return root;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int rightSum = dfs(root.right, sum);
        int prevRoot = root.val;
        root.val += sum + rightSum;
        int leftSum = dfs(root.left, root.val);


        return prevRoot + rightSum + leftSum;
    }

    private static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
