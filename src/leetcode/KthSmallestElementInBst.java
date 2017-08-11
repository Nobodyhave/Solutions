package leetcode;

/**
 * Created by Aleksandr on 18/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 */
public class KthSmallestElementInBst {
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        kthSmallest(root, k, 0);

        return result;
    }

    private int kthSmallest(TreeNode root, int k, int count) {
        if (root == null) {
            return 0;
        }

        int countLeft = kthSmallest(root.left, k, count);
        if (count + countLeft + 1 == k) {
            result = root.val;
        }
        int countRight = kthSmallest(root.right, k, count + countLeft + 1);

        return countLeft + 1 + countRight;
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
