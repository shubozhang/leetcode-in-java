package com.leetcode.binarysearch.easy

import spock.lang.Specification

class L1385FindTheDistanceValueBetweenTwoArraysTest extends Specification {

    def "L1385 find the distance value between two arrays"() {
        expect:
        L1385FindTheDistanceValueBetweenTwoArrays.findTheDistanceValue(arr1 as int[], arr2 as int[], d) == counter

        where:
        arr1           | arr2                    | d || counter
        [4, 5, 8]      | [10, 9, 1, 8]           | 2 || 2
        [1, 4, 2, 3]   | [-4, -3, 6, 10, 20, 30] | 3 || 2
        [2, 1, 100, 3] | [-5, -2, 10, -3, 7]     | 6 || 1
    }
}
