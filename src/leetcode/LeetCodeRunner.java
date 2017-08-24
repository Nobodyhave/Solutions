package leetcode;

import java.io.FileNotFoundException;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 */
public class LeetCodeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        /*PalindromeLinkedList.ListNode node = new PalindromeLinkedList.ListNode(1);
        PalindromeLinkedList.ListNode start = node;
        node.next = new PalindromeLinkedList.ListNode(2);
        node = node.next;
        node.next = new PalindromeLinkedList.ListNode(3);
        node = node.next;
        node.next = new PalindromeLinkedList.ListNode(3);
        node = node.next;
        node.next = new PalindromeLinkedList.ListNode(2);
        node = node.next;
        node.next = new PalindromeLinkedList.ListNode(1);
        node = node.next;*/
        /*ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(5);
        root.left = new ValidateBinarySearchTree.TreeNode(14);
        root.left.left = new ValidateBinarySearchTree.TreeNode(1);*/
        //new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
    }
}
