package com.leetcode.linkedlist;

import com.model.ListNode;

/**
 https://leetcode.com/problems/reverse-linked-list/

 Given the head of a singly linked list, reverse the list, and return the reversed list.

 Example 1:
 Input: head = [1,2,3,4,5]
 Output: [5,4,3,2,1]

 Example 2:
 Input: head = [1,2]
 Output: [2,1]

 Example 3:
 Input: head = []
 Output: []

 Constraints:
 1) The number of nodes in the list is the range [0, 5000].
 2) -5000 <= Node.val <= 5000


 Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 * */
public class L206ReverseLinkedList {

    public static ListNode reverseByIterator(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = new ListNode(head.val, null);
            if (dummy.next != null) {
                node.next = dummy.next;
            }
            dummy.next = node;
            head = head.next;
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head =temp;
        }
        return prev;
    }
}
