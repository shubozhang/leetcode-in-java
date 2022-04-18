package com.leetcode.linkedlist.easy

import com.model.ListNode
import org.junit.Before
import spock.lang.Specification

class L083RemoveDuplicatesFromSortedListTest extends Specification {

    public static ListNode head11
    public static ListNode head21
    public static ListNode head31
    public static ListNode head41
    public static ListNode head51
    public static ListNode head61

    @Before
    void setup() {
        // 1->1->2->null
        ListNode node11 = new ListNode(1)
        ListNode node12 = new ListNode(1)
        ListNode node13 = new ListNode(2)
        node11.next = node12
        node12.next = node13
        head11 = node11

        ListNode node21 = new ListNode(1)
        ListNode node22 = new ListNode(2)
        node21.next = node22
        head21 = node11

        // 1->1->2->3->3->null
        ListNode node31 = new ListNode(1)
        ListNode node32 = new ListNode(1)
        ListNode node33 = new ListNode(2)
        ListNode node34 = new ListNode(3)
        ListNode node35 = new ListNode(3)
        node31.next = node32
        node32.next = node33
        node33.next = node34
        node34.next = node35
        head31 = node31

        ListNode node41 = new ListNode(1)
        ListNode node42 = new ListNode(2)
        ListNode node43 = new ListNode(3)
        node41.next = node42
        node42.next = node43
        head41 = node41

        // 1 --> 1 --> 1 --> null
        ListNode node51 = new ListNode(1)
        ListNode node52 = new ListNode(1)
        ListNode node53 = new ListNode(1)
        node51.next = node52
        node52.next = node53
        head51 = node51

        ListNode node61 = new ListNode(1)
        head61 = node61
    }

    def "remove duplicates from sorted list"() {
        expect:
        L083RemoveDuplicatesFromSortedList.remove(head as ListNode) == res as ListNode

        where:
        head   || res
        head11 || head21
        head31 || head41
        head51 || head61
        null   || null

    }
}
