package com.leetcode.binarysearch.easy

import spock.lang.Specification

class L704BinarySearchTest extends Specification {

    def "test binary search on int array"() {
        expect:
        L704BinarySearch.search(arr as int[], target) == index

        where:
        arr                    | target || index
        [1, 2, 3]              | 2      || 1
        [1, 2, 3, 3, 4, 5, 10] | 10     || 6
        [1, 2, 3, 3, 4, 5, 10] | 20     || -1
        []                     | 20     || -1
    }
}
