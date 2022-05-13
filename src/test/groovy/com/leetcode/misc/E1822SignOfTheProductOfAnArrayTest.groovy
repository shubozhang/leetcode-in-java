package com.leetcode.misc

import spock.lang.Specification

class E1822SignOfTheProductOfAnArrayTest extends Specification {

    def "sign of the product of an array"() {
        expect:
        new E1822SignOfTheProductOfAnArray().arraySign(nums as int[]) == res

        where:
        nums                      || res
        [-1, -2, -3, -4, 3, 2, 1] || 1
        [1, 5, 0, 2, -3]          || 0
        [-1, 1, -1, 1, -1]        || -1
    }

    def "sign of the product of an array version B"() {
        expect:
        new E1822SignOfTheProductOfAnArray().arraySignB(nums as int[]) == res

        where:
        nums                      || res
        [-1, -2, -3, -4, 3, 2, 1] || 1
        [1, 5, 0, 2, -3]          || 0
        [-1, 1, -1, 1, -1]        || -1
    }
}
