package com.leetcode.binarysearch

import spock.lang.Specification

class M658FindKClosestElementsTest extends Specification {

    def "find k closest elements"() {
        expect:
        M658FindKClosestElements.findB(arr as int[], k, x) == res as int[]

        where:
        arr             | k | x  || res
        [1, 2, 3, 4, 5] | 4 | 3  || [1, 2, 3, 4]
        [1, 2, 3, 4, 5] | 4 | -1 || [1, 2, 3, 4]
    }
}
