package com.leetcode.linkedlist;


import com.model.ListNode;

/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

 Description
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 numbers from the original list.

 Linked list length <= 20000

 Example 1:
 Input: linked list = null
 Output: null
 Explanation: Empty linked list returns null

 Example 2:
 Input: linked list = 1->2->3->3->4->4->5->null
 Output: 1->2->5->null
 Explanation: Delete all 3 and 4

 Example 3:
 Input: linked list = 1->1->1->2->3->null
 Output: 2->3->null
 Explanation: Delete all 1


 Node1 might be deleted, so it will not always return the same head.
 In this case, we consider dummy node.
 * */
public class L082RemoveDuplicatesFromSortedListII {

    public static ListNode remove(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
