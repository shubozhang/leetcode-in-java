package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.E704BinarySearch
import spock.lang.Specification

class E704BinarySearchTest extends Specification {

    def "test binary search in int array"() {
        expect:
        E704BinarySearch.search(arr as int[], target) == index

        where:
        arr                                              | target || index
        [1, 2, 3]                                        | 2      || 1
        [1, 2, 3, 3, 4, 5, 10]                           | 10     || 6
        [1, 2, 3, 3, 4, 5, 10]                           | 20     || -1
        []                                               | 20     || -1
        [1, 2, 3, 4, 5, 6, 7, 8, 10, 100, 150, 156, 179] | 9      || -1
    }
}
