package com.leetcode.linkedlist.easy;

import com.model.ListNode;

/**
 Description
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Linked list length <= 30000

 Example 1:
 Input: linked list = null
 Output: null
 Explanation: Empty linked list returns null

 Example 2:
 Input: linked list = 1->1->2->null
 Output: 1->2->null
 Explanation: Delete duplicate 1

 Example 3:
 Input: linked list = 1->1->2->3->3->null
 Output: 1->2->3->null
 Explanation: Delete duplicate 1 and 3

 Node1 won't be deleted, so it will always return the same head.
 * */
public class L083RemoveDuplicatesFromSortedList {

    public static ListNode remove(ListNode head) {
        for(ListNode node = head; node != null; node = node.next) {
            while (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }
        }
        return head;
    }
}
