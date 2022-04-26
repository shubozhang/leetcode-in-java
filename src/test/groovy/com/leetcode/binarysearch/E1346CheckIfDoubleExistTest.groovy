package com.leetcode.binarysearch

import spock.lang.Specification

class E1346CheckIfDoubleExistTest extends Specification {

    def "check if double number exist"() {
        expect:
        E1346CheckIfDoubleExist.checkB(arr as int[]) == res

        where:
        arr            || res
        [10, 2, 5, 3]  || true
        [7, 1, 14, 11] || true
        [3, 1, 7, 11]  || false
    }
}
