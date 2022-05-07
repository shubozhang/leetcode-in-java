package com.leetcode.linkedlist;


import com.model.ListNode;

/**
 https://leetcode.com/problems/middle-of-the-linked-list/

 Given the head of a singly linked list, return the middle node of the linked list.
 If there are two middle nodes, return the second middle node.

 Example 1:
 Input: head = [1,2,3,4,5]
 Output: [3,4,5]
 Explanation: The middle node of the list is node 3.

 Example 2:
 Input: head = [1,2,3,4,5,6]
 Output: [4,5,6]
 Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 Constraints:
 1) The number of nodes in the list is in the range [1, 100].
 2) 1 <= Node.val <= 100
 * */
public class L876MiddleOfTheLinkedList {

    /**
     Data stream problem: the size of the list is keeping increasing ,and it is not possible to re-iterate
     the list.
     * */
    public static ListNode middleNodeA(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode middleNodeB(ListNode head) {

        return null;
    }
}
