package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.E035SearchInsertPosition
import spock.lang.Specification

class E035SearchInsertPositionTest extends Specification {

    def "L035 search insert position"() {
        expect:
        E035SearchInsertPosition.searchInsert(nums as int[], target) == index

        where:
        nums         | target || index
        [1, 3, 5, 6] | 5      || 2
        [1, 3, 5, 6] | 2      || 1
        [1, 3, 5, 6] | 7      || 4

    }
}
