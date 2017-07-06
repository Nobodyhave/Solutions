package leetcode;

/**
 * Created by Aleksandr on 27/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 */
public class RootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumNumbers(root, new StringBuilder());
    }

    private static int sumNumbers(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            final int sum = Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return sum;
        } else if (root.left == null) {
            sb.append(root.val);
            final int sum = sumNumbers(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sum;
        } else if (root.right == null) {
            sb.append(root.val);
            final int sum = sumNumbers(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sum;
        } else {
            sb.append(root.val);
            final int sum = sumNumbers(root.left, sb) + sumNumbers(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sum;
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
