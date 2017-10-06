package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 27/09/2017.
 * Project Solutions
 */
public class MostFrequentSubTreeSum {
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        final Map<Integer, Integer> frequencies = new HashMap<>();

        postOrder(root, frequencies);

        return frequencies.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFreq)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private int postOrder(TreeNode root, Map<Integer, Integer> freqs) {
        if (root == null) {
            return 0;
        }

        final int sum = postOrder(root.left, freqs) + postOrder(root.right, freqs) + root.val;
        final int f = freqs.getOrDefault(sum, 0) + 1;

        freqs.put(sum, f);
        maxFreq = Math.max(maxFreq, f);

        return sum;
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
