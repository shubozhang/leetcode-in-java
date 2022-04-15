package com.leetcode.dynamicprogramming.medium

import com.leetcode.dynamicprogramming.medium.L062UniquePaths
import spock.lang.Specification

class L062UniquePathsTest extends Specification {

    def "find unique paths"() {
        expect:
        L062UniquePaths.search(m, n) == res

        where:
        m | n || res
        1 | 3 || 1
        3 | 3 || 6
    }
}