package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.medium.T159FindMinimumInRotatedSortedArray
import spock.lang.Specification

class T159FindMinimumInRotatedSortedArrayTest extends Specification {

    def "find minimum in rotated sorted array without duplicates"() {

        expect:
        T159FindMinimumInRotatedSortedArray.find(arr as int[]) == result

        where:
        arr                   || result
        [4, 5, 6, 7, 0, 1, 2] || 0
        [2, 1]                || 1
    }
}
