package com.leetcode.linkedlist.easy

import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class L021MergeTwoSortedListsTest extends Specification {

    def "merge two sorted lists" (){
        given:
        ListNode node1 = new ListNode(1)
        ListNode node2 = new ListNode(2)
        int[] expect = [1, 2]

        when:
        ListNode res = L021MergeTwoSortedLists.mergeTwoLists(node1, node2)

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res) == expect)
    }
}
