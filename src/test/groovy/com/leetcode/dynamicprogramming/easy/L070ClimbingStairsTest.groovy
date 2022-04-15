package com.leetcode.dynamicprogramming.easy

import com.leetcode.dynamicprogramming.easy.L070ClimbingStairs
import spock.lang.Specification

class L070ClimbingStairsTest extends Specification {

    def "climbing stairs in non-recursive way"() {
        expect:
        L070ClimbingStairs.searchA(n) == res

        where:
        n || res
        1 || 1
        3 || 3
    }

    def "climbing stairs in recursive way"() {
        expect:
        L070ClimbingStairs.searchB(n) == res

        where:
        n || res
        1 || 1
        3 || 3
    }
}
