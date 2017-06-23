package leetcode;

/**
 * Created by Aleksandr on 23/06/2017.
 * Project Solutions
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            final TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode currentNext = dummy;
            while (root != null) {
                if (root.left != null) {
                    currentNext.next = root.left;
                    currentNext = currentNext.next;
                }
                if (root.right != null) {
                    currentNext.next = root.right;
                    currentNext = currentNext.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
