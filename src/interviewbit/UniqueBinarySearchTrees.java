package interviewbit;

import java.util.ArrayList;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 * <p>
 * https://www.interviewbit.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
    public ArrayList<TreeNode> generateTrees(int a) {
        if (a <= 0) {
            return null;
        }

        return buildTree(1, a);
    }

    private ArrayList<TreeNode> buildTree(int left, int right) {
        final ArrayList<TreeNode> list = new ArrayList<>();

        if (left > right) {
            list.add(null);
        } else if (left == right) {
            list.add(new TreeNode(left));
        } else {
            for (int i = left; i <= right; i++) {
                final ArrayList<TreeNode> leftTrees = buildTree(left, i - 1);
                final ArrayList<TreeNode> rightTrees = buildTree(i + 1, right);

                for (TreeNode l : leftTrees) {
                    for (TreeNode r : rightTrees) {
                        final TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        list.add(cur);
                    }
                }
            }
        }

        return list;
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
