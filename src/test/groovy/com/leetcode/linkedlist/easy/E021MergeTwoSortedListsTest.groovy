package com.leetcode.linkedlist.easy

import com.leetcode.linkedlist.E021MergeTwoSortedLists
import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class E021MergeTwoSortedListsTest extends Specification {

    def "merge two sorted lists" (){
        given:
        ListNode node1 = new ListNode(1)
        ListNode node2 = new ListNode(2)
        int[] expect = [1, 2]

        when:
        ListNode res = E021MergeTwoSortedLists.mergeTwoLists(node1, node2)

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res) == expect)
    }
}
