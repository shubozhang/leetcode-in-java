package com.leetcode.linkedlist

import com.model.ListNode
import com.utils.ListNodeUtils
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class M002AddTwoNumbersTest extends Specification {

    def "add two numbers"() {
        when:
        ListNode res = M002AddTwoNumbers.addTwoNumbers(ListNodeUtils.generateListNodeFromArray(l1 as int[]), ListNodeUtils.generateListNodeFromArray(l2 as int[]))

        then:
        assertTrue(ListNodeUtils.extractListNodeToInt(res) == expected as int[])

        where:
        l1                    | l2           || expected
        [2, 4, 3]             | [5, 6, 4]    || [7, 0, 8]
        [0]                   | [0]          || [0]
        [9, 9, 9, 9, 9, 9, 9] | [9, 9, 9, 9] || [8, 9, 9, 9, 0, 0, 0, 1]

    }
}
