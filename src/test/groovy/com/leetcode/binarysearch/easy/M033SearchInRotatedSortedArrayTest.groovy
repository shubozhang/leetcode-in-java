package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.M033SearchInRotatedSortedArray
import spock.lang.Specification

class M033SearchInRotatedSortedArrayTest extends Specification {

    def "search in rotated sorted array without dup"() {
        expect:
        M033SearchInRotatedSortedArray.search(nums as int[], target) == index

        where:
        nums            | target || index
        [4, 5, 1, 2, 3] | 1      || 2
        [4, 5, 1, 2, 3] | 0      || -1
        null            | 0      || -1
        []              | 0      || -1
    }
}
