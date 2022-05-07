package com.leetcode.doublepointers

import spock.lang.Specification

class M016ThreeSumClosestTest extends Specification {

    def "three sum closet"() {
        expect:
        new M016ThreeSumClosest().threeSumClosest(nums as int[], target) == res

        where:
        nums           | target || res
        [-1, 2, 1, -4] | 1      || 2
        [0, 0, 0]      | 1      || 0
        [1, 1, 1, 0]   | 100    || 3
    }
}
