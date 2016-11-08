package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 04/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-linked-list
 */
public class LinkedList {

    public static void main(String args[]) {
        final Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }

    private static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static Node insert(Node head, int data) {
        if (head == null) {
            return new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
            return head;
        }
    }

    private static class Node {
        private int data;
        private Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
