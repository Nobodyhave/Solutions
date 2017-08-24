package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksandr on 17/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        return Arrays.asList(new Bst(nums).ans);
    }

    private static class Bst {
        private Node root;
        private Integer[] ans;

        Bst(int[] nums) {
            ans = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insert(root, nums[i], ans, i, 0);
            }
        }

        private Node insert(Node root, int num, Integer[] ans, int i, int preSum) {
            if (root == null) {
                root = new Node(num, 0);
                ans[i] = preSum;
            } else if (root.val == num) {
                root.duplicate++;
                ans[i] = preSum + root.sum;
            } else if (root.val > num) {
                root.sum++;
                root.left = insert(root.left, num, ans, i, preSum);
            } else {
                root.right = insert(root.right, num, ans, i, preSum + root.duplicate + root.sum);
            }

            return root;
        }

        private static class Node {
            private int val;
            private int sum;
            private int duplicate = 1;
            private Node left;
            private Node right;

            Node(int val, int sum) {
                this.val = val;
                this.sum = sum;
            }
        }
    }
}
