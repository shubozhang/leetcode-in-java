package com.leetcode.binarysearch

import spock.lang.Specification

class E441ArrangingCoinsTest extends Specification {

    def "arrange coins version A"() {
        expect:
        E441ArrangingCoins.arrangeA(n) == res

        where:
        n          || res
        5          || 2
        8          || 3
        1804289383 || 60070
    }

    def "arrange coins version B"() {
        expect:
        E441ArrangingCoins.arrangeB(n) == res

        where:
        n          || res
        5          || 2
        8          || 3
        1804289383 || 60070
    }
}
