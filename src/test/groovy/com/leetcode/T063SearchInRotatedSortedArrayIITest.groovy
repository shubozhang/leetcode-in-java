package com.leetcode

import spock.lang.Specification

class T063SearchInRotatedSortedArrayIITest extends Specification {

    def "search in rotated sorted array with duplicates"() {
        expect:
        T063SearchInRotatedSortedArrayII.search(nums as int[], target) == index

        where:
        nums                     | target || index
        [4, 5, 1, 2, 3]          | 1      || true
        [4, 5, 1, 2, 3]          | 0      || false
        null                     | 0      || false
        []                       | 0      || false
        [3, 4, 4, 5, 7, 0, 1, 2] | 4      || true
    }
}
