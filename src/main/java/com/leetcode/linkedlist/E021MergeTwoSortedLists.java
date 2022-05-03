package com.leetcode.linkedlist;

import com.model.ListNode;

/**
 https://leetcode.com/problems/merge-two-sorted-lists/

 You are given the heads of two sorted linked lists list1 and list2.

 Merge the two lists in a one sorted list. The list should be made by splicing together
 the nodes of the first two lists.

 Return the head of the merged linked list.

 Example 1:
 Input: list1 = [1,2,4], list2 = [1,3,4]
 Output: [1,1,2,3,4,4]

 Example 2:
 Input: list1 = [], list2 = []
 Output: []

 Example 3:
 Input: list1 = [], list2 = [0]
 Output: [0]

 Constraints:
 1) The number of nodes in both lists is in the range [0, 50].
 2) -100 <= Node.val <= 100
 3) Both list1 and list2 are sorted in non-decreasing order.
 * */
public class E021MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null ) {return list2;}
        if (list2 == null ) {return list1;}

        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        list1 = dummy;

        while (list2 != null && list1.next != null) {
            if (list2.val <= list1.next.val) {
                ListNode node = new ListNode(list2.val);
                ListNode temp = list1.next;
                list1.next = node;
                node.next = temp;

                list1 = list1.next;
                list2 = list2.next;
            } else {
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            list1.next = list2;
        }

        return dummy.next;
    }
}
