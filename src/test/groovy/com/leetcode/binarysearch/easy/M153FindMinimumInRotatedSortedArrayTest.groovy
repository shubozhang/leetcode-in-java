package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.M153FindMinimumInRotatedSortedArray
import spock.lang.Specification

class M153FindMinimumInRotatedSortedArrayTest extends Specification {

    def "find minimum in rotated sorted array without duplicates"() {

        expect:
        M153FindMinimumInRotatedSortedArray.find(arr as int[]) == result

        where:
        arr                   || result
        [4, 5, 6, 7, 0, 1, 2] || 0
        [2, 1]                || 1
    }
}
