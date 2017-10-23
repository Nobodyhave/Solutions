package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 23/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/find-duplicate-subtrees
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        final Map<String, List<TreeNode>> map = new HashMap<>();
        collectDuplicates(map, new StringBuilder(), root, 0);

        for (List<TreeNode> nodes : map.values()) {
            if (nodes.size() > 1) {
                result.add(nodes.get(0));
            }
        }

        return result;
    }

    private void collectDuplicates(Map<String, List<TreeNode>> map, StringBuilder sb, TreeNode root, int index) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        collectDuplicates(map, sb, root.left, sb.length());
        collectDuplicates(map, sb, root.right, sb.length());

        final String preorder = sb.substring(index);
        map.computeIfAbsent(preorder, key -> new ArrayList<>());
        map.get(preorder).add(root);
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
