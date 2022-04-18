package com.leetcode.array.sortedarray

import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertTrue

class E088MergeSortedArrayTest extends Specification {

    def "merge sorted array"() {
        when:
        int[] res = E088MergeSortedArray.merge(num1 as int[], m, num2 as int[], n)

        then:
        assertTrue(expect as int[] == res)

        where:
        num1               | m | num2      | n || expect
        [0]                | 0 | [1]       | 1 || [1]
        [1, 2, 3, 0, 0, 0] | 3 | [2, 5, 6] | 3 || [1, 2, 2, 3, 5, 6]
    }
}
