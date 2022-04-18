package com.leetcode.array

import spock.lang.Specification

class ET080MedianOfUnsortedArrayTest extends Specification {

    def "find median of an unsorted array"() {
        expect:
        ET080MedianOfUnsortedArray.median(nums as int[]) == res

        where:
        nums            || res
        [4, 5, 1, 2, 3] || 3
        [7, 9, 4, 5]    || 5

    }
}
