package com.lintcode.dynamicprogramming.easy

import spock.lang.Specification

class T111ClimbingStairsTest extends Specification {

    def "climbing stairs in non-recursive way"() {
        expect:
        T111ClimbingStairs.searchA(n) == res

        where:
        n || res
        1 || 1
        3 || 3
    }

    def "climbing stairs in recursive way"() {
        expect:
        T111ClimbingStairs.searchB(n) == res

        where:
        n || res
        1 || 1
        3 || 3
    }
}
