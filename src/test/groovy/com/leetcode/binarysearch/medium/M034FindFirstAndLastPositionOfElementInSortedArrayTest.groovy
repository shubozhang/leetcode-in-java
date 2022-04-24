package com.leetcode.binarysearch.medium

import com.leetcode.binarysearch.M034FindFirstAndLastPositionOfElementInSortedArray
import spock.lang.Specification

class M034FindFirstAndLastPositionOfElementInSortedArrayTest extends Specification {

    def "find first and last postion of element in sorted array"() {
        expect:
        M034FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums as int[], target) == res as int[]

        where:
        nums                | target || res
        [5, 7, 7, 8, 8, 10] | 8      || [3, 4]
    }
}
