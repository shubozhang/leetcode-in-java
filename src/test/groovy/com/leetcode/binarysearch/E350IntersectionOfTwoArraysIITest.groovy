package com.leetcode.binarysearch

import com.leetcode.doublepointers.E350IntersectionOfTwoArraysII
import spock.lang.Specification

class E350IntersectionOfTwoArraysIITest extends Specification {

    def "intersection of two arrays"() {
        expect:
        E350IntersectionOfTwoArraysII.intersection(nums1 as int[], nums2 as int[]) == res as int[]

        where:
        nums1        | nums2           || res
        [1, 2, 2, 1] | [2, 2]          || [2, 2]
        [4, 9, 5]    | [9, 4, 9, 8, 4] || [4, 9]
    }
}
