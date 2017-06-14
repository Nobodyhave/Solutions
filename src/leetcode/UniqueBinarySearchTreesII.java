package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 08/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees-ii
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        final List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
        } else if (start == end) {
            list.add(new TreeNode(start));
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generateTrees(start, i - 1);
                List<TreeNode> right = generateTrees(i + 1, end);

                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }

        }

        return list;
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
