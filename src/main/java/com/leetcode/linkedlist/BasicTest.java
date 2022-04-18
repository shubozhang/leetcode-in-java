package com.leetcode.linkedlist;

import com.model.ListNode;

public class BasicTest {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = node1;
        
        printListNode(head);

        node1 = node2;

        printListNode(head);
    }
    
    public static void printListNode(ListNode head) {
        for (ListNode node = head; node != null;  node = node.next) {
            System.out.print(node.val);
            System.out.print("-->");
        }
        System.out.print("null");
        System.out.println();
    }
}
