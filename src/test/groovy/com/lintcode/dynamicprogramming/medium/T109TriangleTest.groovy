package com.lintcode.dynamicprogramming.medium

import spock.lang.Specification

class T109TriangleTest extends Specification {

    def "triangle A"() {
        expect:
        T109Triangle.minimumTotalA(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }

    def "triangle B"() {
        expect:
        T109Triangle.minimumTotalB(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }

    def "triangle C"() {
        expect:
        new T109Triangle().minimumTotalC(triangle as int[][]) == sum

        where:
        triangle                              || sum
        [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]] || 11
        [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]] || 12

    }
}
