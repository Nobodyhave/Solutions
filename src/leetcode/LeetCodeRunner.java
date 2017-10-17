package leetcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //new ZumaGame().collapseTable("WWBBBWW");
        final List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(new ExclusiveTimeOfFunctions().exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")));
    }
}
