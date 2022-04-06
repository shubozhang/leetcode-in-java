package com.leetcode.binarysearch.easy

import spock.lang.Specification

class L035SearchInsertPositionTest extends Specification {

    def "L035 search insert position"() {
        expect:
        L035SearchInsertPosition.searchInsert(nums as int[], target) == index

        where:
        nums         | target || index
        [1, 3, 5, 6] | 5      || 2
        [1, 3, 5, 6] | 2      || 1
        [1, 3, 5, 6] | 7      || 4

    }
}
