package com.leetcode.linkedlist;


import com.model.ListNode;

/**
 https://leetcode.com/problems/reverse-linked-list-ii/

 Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right, and return the reversed list.

 Example 1:
 Input: head = [1,2,3,4,5], left = 2, right = 4
 Output: [1,4,3,2,5]

 Example 2:
 Input: head = [5], left = 1, right = 1
 Output: [5]

 Constraints:
 1) The number of nodes in the list is n.
 2) 1 <= n <= 500
 3) -500 <= Node.val <= 500
 4) 1 <= left <= right <= n


 Follow up: Could you do it in one pass?
 * */
public class L092ReverseLinkedListII {

    public static ListNode reverse(ListNode head, int left, int right) {
        if (head == null || head.next == null || left >= right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // find pre left node
        for (int i = 1; i < left; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode preLeft = head;
        ListNode leftNode = head.next;

        // reverse linked list between leftNode and rightNode
        // prepare to iterate start from leftNode
        ListNode rightNode = leftNode;
        ListNode postRightNode = leftNode.next;
        for (int i = left; i < right; i++) {
            if (postRightNode == null){
                return null;
            }
            ListNode temp = postRightNode.next;
            postRightNode.next = rightNode;
            rightNode = postRightNode;
            postRightNode = temp;
        }
        // connect leftNode to postRightNode;
        leftNode.next = postRightNode;

        // connect preLeft to right node
        preLeft.next = rightNode;

        return dummy.next;
    }
}
