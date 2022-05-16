package com.leetcode.misc

import spock.lang.Specification

class E605CanPlaceFlowersTest extends Specification {

    def "can place flowers"() {
        expect:
        new E605CanPlaceFlowers().canPlaceFlowers(nums as int[], n) == res

        where:
        nums            | n || res
        [1, 0, 0, 0, 1] | 1 || true
        [1, 0, 0, 0, 1] | 2 || false
        [0]             | 0 || true
        [1]             | 0 || true
    }
}
