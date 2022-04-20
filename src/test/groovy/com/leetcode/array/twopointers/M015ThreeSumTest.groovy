package com.leetcode.array.twopointers

import spock.lang.Specification

class M015ThreeSumTest extends Specification {

    def "find three sum"() {
        expect:
        M015ThreeSum.find(nums as int[]) == res as int[][]

        where:
        nums                  || res
        [-1, 0, 1, 2, -1, -4] || [[-1, -1, 2], [-1, 0, 1]]
        []                    || []
        [0]                   || []
    }
}
