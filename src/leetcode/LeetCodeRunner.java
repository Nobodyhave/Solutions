package leetcode;

import java.io.FileNotFoundException;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 */
public class LeetCodeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        /*ReverseNodesInKGroup.ListNode node = new ReverseNodesInKGroup.ListNode(1);
        ReverseNodesInKGroup.ListNode start = node;
        node.next = new ReverseNodesInKGroup.ListNode(2);
        node = node.next;
        node.next = new ReverseNodesInKGroup.ListNode(3);
        node = node.next;
        node.next = new ReverseNodesInKGroup.ListNode(4);
        node = node.next;
        node.next = new ReverseNodesInKGroup.ListNode(5);
        node = node.next;*/
        /*ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(5);
        root.left = new ValidateBinarySearchTree.TreeNode(14);
        root.left.left = new ValidateBinarySearchTree.TreeNode(1);*/
        //System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{8,4,2,1,6,5,7,12,10,9,11,14,13,15}, new int[]{1,2,4,5,6,7,8,9,10,11,12,13,14,15}));
        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
    }
}
