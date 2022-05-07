package com.leetcode.linkedlist;

import com.model.ListNode;

/**
 https://leetcode.com/problems/add-two-numbers/
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example 1:
 Input: l1 = [2,4,3], l2 = [5,6,4]
 Output: [7,0,8]
 Explanation: 342 + 465 = 807.

 Example 2:
 Input: l1 = [0], l2 = [0]
 Output: [0]

 Example 3:
 Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 Output: [8,9,9,9,0,0,0,1]

 Constraints:
 1) The number of nodes in each linked list is in the range [1, 100].
 2) 0 <= Node.val <= 9
 3) It is guaranteed that the list represents a number that does not have leading zeros.
 * */
public class M002AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dummy;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x1 = (p1 != null) ? p1.val : 0;
            int x2 = (p2 != null) ? p2.val : 0;
            int val = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            curr.next = new ListNode(val);
            curr = curr.next;

            p1 = (p1 != null) ? p1.next : null;
            p2 = (p2 != null) ? p2.next : null;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
