package leetcode;

import java.io.FileNotFoundException;

/**
 * Created by Aleksandr on 26/04/2017.
 * Project Solutions
 */
public class LeetCodeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        /*InsertionSortList.ListNode node = new InsertionSortList.ListNode(3);
        InsertionSortList.ListNode start = node;
        node.next = new InsertionSortList.ListNode(2);
        node = node.next;
        node.next = new InsertionSortList.ListNode(1);
        node = node.next;
        node.next = new InsertionSortList.ListNode(4);
        node = node.next;
        node.next = new InsertionSortList.ListNode(5);
        node = node.next;
        node.next = new InsertionSortList.ListNode(6);
        node = node.next;*/
        /*ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(5);
        root.left = new ValidateBinarySearchTree.TreeNode(14);
        root.left.left = new ValidateBinarySearchTree.TreeNode(1);*/
        System.out.println(new RepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
