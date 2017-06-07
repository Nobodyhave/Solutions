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
        System.out.println(new RestoreIpAddress().restoreIpAddresses("172162541"));
    }
}
