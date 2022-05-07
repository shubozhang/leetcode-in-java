package com.leetcode.linkedlist.easy

import com.leetcode.linkedlist.L206ReverseLinkedList
import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class L206ReverseLinkedListTest extends Specification {

    def "reverse linked list" (){
        given:
        int[] input = [1, 2, 3]
        int[] expected1 = [3, 2, 1]

        when:
        ListNode res1 = L206ReverseLinkedList.reverseByIterator(ListNodeUtils.generateListNodeFromArray(input))

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res1) == expected1)
    }
}
