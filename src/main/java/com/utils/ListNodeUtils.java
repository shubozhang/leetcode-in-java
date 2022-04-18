package com.utils;

import com.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtils {

    public static ListNode generateListNodeFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummpy = new ListNode(0);
        ListNode head = new ListNode(arr[0]);
        dummpy.next = head;
        head = dummpy;

        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            head.next = node;
            head = head.next;
        }

        return dummpy.next;
    }

    public static int[] extractListNodeToInt(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printListNode(ListNode head) {
        int[] res = extractListNodeToInt(head);
        for (int i = 0; i < res.length; i++) {
            System.out.print(i + "->");
        }
    }
}
