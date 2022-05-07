package com.leetcode.doublepointers

import spock.lang.Specification

class M018FourSumTest extends Specification {

    def "four sum"() {
        expect:
        new M018FourSum().fourSum(nums as int[], target as int) as int[][] == res as int[][]

        where:
        nums                                                             | target || res
        [1, 0, -1, 0, -2, 2]                                             | 0      || [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        [2, 2, 2, 2, 2]                                                  | 8      || [[2, 2, 2, 2]]
        [4, -9, -2, -2, -7, 9, 9, 5, 10, -10, 4, 5, 2, -4, -2, 4, -9, 5] | -13    || [[-10, -9, -4, 10], [-10, -9, 2, 4], [-9, -9, -4, 9], [-9, -7, -2, 5], [-9, -4, -2, 2], [-7, -2, -2, -2]]
    }
}
