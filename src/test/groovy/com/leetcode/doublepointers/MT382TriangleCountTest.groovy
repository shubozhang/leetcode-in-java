package com.leetcode.doublepointers

import spock.lang.Specification

class MT382TriangleCountTest extends Specification {

    def "count triangle"() {
        expect:
        new MT382TriangleCount().triangleCount(nums as int[]) == res

        where:
        nums         || res
        [3, 4, 6, 7] || 3
        [4, 4, 4, 4] || 4
    }
}
