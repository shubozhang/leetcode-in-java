package com.leetcode.linkedlist.medium

import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static junit.framework.TestCase.assertTrue

class L082RemoveDuplicatesFromSortedListIITest extends Specification {

    def "remove duplicates from sorted list II"() {
        given:
        // 1->2->3->3->4->4->5->null
        ListNode node17 = new ListNode(5)
        ListNode node16 = new ListNode(4, node17)
        ListNode node15 = new ListNode(4, node16)
        ListNode node14 = new ListNode(3, node15)
        ListNode node13 = new ListNode(3, node14)
        ListNode node12 = new ListNode(2, node13)
        ListNode node11 = new ListNode(1, node12)
        ListNode head11 = node11

        int[] arr1 = [1, 2, 5]

        // 1->1->1->2->3->null
        ListNode node35 = new ListNode(3)
        ListNode node34 = new ListNode(2, node35)
        ListNode node33 = new ListNode(1, node34)
        ListNode node32 = new ListNode(1, node33)
        ListNode node31 = new ListNode(1, node32)
        ListNode head31 = node31

        int[] arr2 = [2, 3]

        when:
        ListNode res1 = L082RemoveDuplicatesFromSortedListII.remove(head11)
        ListNode res2 = L082RemoveDuplicatesFromSortedListII.remove(head31)

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res1).toArray() as int[] == arr1)
        assertTrue(ListNodeUtils.extractListNodeToInt(res2).toArray() as int[] == arr2)
    }
}
