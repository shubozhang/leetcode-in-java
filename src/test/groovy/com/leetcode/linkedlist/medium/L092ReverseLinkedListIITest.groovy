package com.leetcode.linkedlist.medium

import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class L092ReverseLinkedListIITest extends Specification {

    def "reverse linked list II" (){
        given:
        int left = 2
        int right = 4
        int[] input = [1,2,3,4,5]
        ListNode head = ListNodeUtils.generateListNodeFromArray(input)
        int[] expect1 = [1, 4, 3, 2, 5];

        when:
        ListNode res = L092ReverseLinkedListII.reverse(head, left, right)

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res) == expect1)
    }
}
