package com.leetcode.linkedlist;

import com.model.ListNode;

public class M142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;

                    if (slow == fast) {
                        return fast;
                    }
                }
                return fast;
            }
        }
        return null;
    }
}