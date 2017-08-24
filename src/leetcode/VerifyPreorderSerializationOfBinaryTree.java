package leetcode;

/**
 * Created by Aleksandr on 22/08/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree
 */
public class VerifyPreorderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) {
            return false;
        }

        final String[] splitPreorder = preorder.split(",");

        return dfs(splitPreorder, 0) + 1 == splitPreorder.length;
    }

    private int dfs(String[] preorder, int index) {
        if("#".equals(preorder[index])) {
            return index;
        } else if(index == -1) {
            return -1;
        }

        int leftIndex = -1;
        if(index + 1 < preorder.length) {
            leftIndex = dfs(preorder, index + 1);
        } else {
            return -1;
        }

        int rightIndex = -1;
        if(leftIndex != -1 && leftIndex + 1 < preorder.length) {
            rightIndex = dfs(preorder, leftIndex + 1);
        } else {
            return -1;
        }

        return rightIndex;
    }
}
