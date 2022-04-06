package com.leetcode.binarysearch.easy

import spock.lang.Specification

class L367ValidPerfectSquareTest extends Specification {

    def "L367 valid perfect square"() {
        expect:
        L367ValidPerfectSquare.isPerfectSquare(num) == res

        where:
        num    || res
        808201 || true
        1      || true
        2      || false
        3      || false
        4      || true
        5      || false
        6      || false
        7      || false
        8      || false
        9      || true
        10     || false
        16     || true

    }
}
