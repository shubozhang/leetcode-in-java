package com.leetcode.dynamicprogramming.easy

import com.leetcode.dynamicprogramming.easy.L064MinimumPathSum
import spock.lang.Specification

class L064MinimumPathSumTest extends Specification {

    def "minimum path sum"() {
        expect:
        L064MinimumPathSum.search(grid as int[][]) == res

        where:
        grid                              || res
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] || 7
        [[1, 3, 2]]                       || 6
    }
}
