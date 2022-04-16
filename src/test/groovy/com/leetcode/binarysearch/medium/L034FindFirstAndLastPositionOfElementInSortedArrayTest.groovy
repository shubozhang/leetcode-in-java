package com.leetcode.binarysearch.medium

import spock.lang.Specification

class L034FindFirstAndLastPositionOfElementInSortedArrayTest extends Specification {

    def "find first and last postion of element in sorted array"() {
        expect:
        L034FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums as int[], target) == res as int[]

        where:
        nums                | target || res
        [5, 7, 7, 8, 8, 10] | 8      || [3, 4]
    }
}
