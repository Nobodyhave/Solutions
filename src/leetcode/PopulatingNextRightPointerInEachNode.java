package leetcode;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 */
public class PopulatingNextRightPointerInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        connectHelper(root, null);
    }

    private void connectHelper(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }

        root.next = next;
        connectHelper(root.left, root.right);
        connectHelper(root.right, next == null ? null : next.left);
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
