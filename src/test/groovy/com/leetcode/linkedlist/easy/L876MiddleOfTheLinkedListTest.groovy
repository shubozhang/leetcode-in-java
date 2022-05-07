package com.leetcode.linkedlist.easy

import com.leetcode.linkedlist.L876MiddleOfTheLinkedList
import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class L876MiddleOfTheLinkedListTest extends Specification {

    def "middel fo the linked list A"() {
        given:
        int[] input1 = [1, 2, 3, 4, 5]
        int[] expect1 = [3, 4, 5]
        int[] input2 = [1, 2, 3, 4, 5, 6]
        int[] expect2 = [4, 5, 6]

        when:
        ListNode res1 = L876MiddleOfTheLinkedList.middleNodeA(ListNodeUtils.generateListNodeFromArray(input1))
        ListNode res2 = L876MiddleOfTheLinkedList.middleNodeA(ListNodeUtils.generateListNodeFromArray(input2))

        then:
        assertTrue(expect1 == ListNodeUtils.extractListNodeToInt(res1))
        assertTrue(expect2 == ListNodeUtils.extractListNodeToInt(res2))

    }
}
