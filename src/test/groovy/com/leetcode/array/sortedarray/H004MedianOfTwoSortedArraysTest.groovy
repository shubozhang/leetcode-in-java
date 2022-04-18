package com.leetcode.array.sortedarray

import spock.lang.Specification

class H004MedianOfTwoSortedArraysTest extends Specification {

    def "find median of two sorted array"() {
        expect:
        H004MedianOfTwoSortedArrays.findMedian(A as int[], B as int[]) == median as double

        where:
        A                  | B            || median
        [1, 2, 3, 4, 5, 6] | [2, 3, 4, 5] || 3.5
        [1, 3]             | [2]          || 2
        [1, 2]             | [3, 4]       || 2.5
    }
}
