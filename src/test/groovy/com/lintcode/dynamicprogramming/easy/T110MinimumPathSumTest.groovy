package com.lintcode.dynamicprogramming.easy

import spock.lang.Specification

class T110MinimumPathSumTest extends Specification {

    def "minimum path sum"() {
        expect:
        T110MinimumPathSum.search(grid as int[][]) == res

        where:
        grid                              || res
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] || 7
        [[1, 3, 2]]                       || 6
    }
}
