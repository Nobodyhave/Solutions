package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/path-sum-iii
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        return dfs(new ArrayList<>(), root, sum);
    }

    private int dfs(List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        final List<Integer> nextList = new ArrayList<>();
        int count = 0;
        for (Integer num : list) {
            if (num + root.val == sum) {
                count++;
            }
            nextList.add(num + root.val);
        }
        nextList.add(root.val);

        return count + dfs(new ArrayList<>(nextList), root.left, sum)
                + dfs(new ArrayList<>(nextList), root.right, sum)
                + (root.val == sum ? 1 : 0);
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
