package com.leetcode.dynamicprogramming.medium

import com.leetcode.dynamicprogramming.medium.L120Triangle
import spock.lang.Specification

class L120TriangleTest extends Specification {

    def "triangle A"() {
        expect:
        L120Triangle.minimumTotalA(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }

    def "triangle B"() {
        expect:
        L120Triangle.minimumTotalB(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }

    def "triangle C"() {
        expect:
        new L120Triangle().minimumTotalC(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }
}
