package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 11/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/binary-tree-right-side-view
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        current.add(root);
        while(!current.isEmpty()) {
            for(int i = 0; i < current.size(); i++) {
                TreeNode node = current.get(i);
                if(node.left != null) {
                    next.add(node.left);
                }
                if(node.right != null) {
                    next.add(node.right);
                }
                if(i == current.size() - 1) {
                    result.add(node.val);
                }
            }

            List<TreeNode> temp = current;
            current = next;
            next = temp;
            next.clear();
        }

        return result;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
