package com.leetcode.array.doublepointers

import com.leetcode.doublepointers.M015ThreeSum
import spock.lang.Specification

class M015ThreeSumTest extends Specification {

    def "find three sum"() {
        expect:
        new M015ThreeSum().versionA(nums as int[]) as int[][] == res as int[][]

        where:
        nums                  || res
        [-1, 0, 1, 2, -1, -4] || [[-1, -1, 2], [-1, 0, 1]]
        []                    || []
        [0]                   || []
    }
}
