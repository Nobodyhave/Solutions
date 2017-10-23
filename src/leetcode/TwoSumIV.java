package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        final List<Integer> inorder = new ArrayList<>();
        dfs(inorder, root);

        int start = 0, end = inorder.size() - 1;
        while (start < end) {
            if (inorder.get(start) + inorder.get(end) > k) {
                end--;
            } else if (inorder.get(start) + inorder.get(end) < k) {
                start++;
            } else {
                return true;
            }
        }

        return false;
    }

    private void dfs(List<Integer> inorder, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(inorder, root.left);
        inorder.add(root.val);
        dfs(inorder, root.right);
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
