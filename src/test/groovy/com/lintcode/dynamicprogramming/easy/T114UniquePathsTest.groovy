package com.lintcode.dynamicprogramming.easy

import spock.lang.Specification

class T114UniquePathsTest extends Specification {

    def "find unique paths"() {
        expect:
        T114UniquePaths.search(m, n) == res

        where:
        m | n || res
        1 | 3 || 1
        3 | 3 || 6
    }
}