package com.leetcode.binarysearch

import spock.lang.Specification

class E1539KthMissingPositiveNumberTest extends Specification {

    def "find kth missing positie number version A"() {
        expect:
        E1539KthMissingPositiveNumber.findA(arr as int[], k) == res

        where:
        arr              | k || res
        [2, 3, 4, 7, 11] | 5 || 9
        [1, 2, 3, 4]     | 2 || 6
    }



    def "find kth missing positie number version B"() {
        expect:
        E1539KthMissingPositiveNumber.findB(arr as int[], k) == res

        where:
        arr              | k || res
        [2, 3, 4, 7, 11] | 5 || 9
        [1, 2, 3, 4]     | 2 || 6
    }
}
