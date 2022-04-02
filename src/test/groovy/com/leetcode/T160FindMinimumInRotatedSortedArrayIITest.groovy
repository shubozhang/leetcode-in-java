package com.leetcode

import spock.lang.Specification

class T160FindMinimumInRotatedSortedArrayIITest extends Specification {

    def "find minimum in rotated sorted array with duplicates"() {

        expect:
        T160FindMinimumInRotatedSortedArrayII.find(arr as int[]) == result

        where:
        arr                      || result
        [4, 5, 6, 7, 0, 1, 2]    || 0
        [2, 1]                   || 1
        [4, 4, 5, 6, 7, 0, 1, 2] || 0
        [1, 2, 2, 2, 2]          || 1
        [1, 1, -1, 1]            || -1
    }
}
