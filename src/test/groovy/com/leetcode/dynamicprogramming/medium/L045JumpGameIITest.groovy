package com.leetcode.dynamicprogramming.medium

import com.leetcode.dynamicprogramming.medium.L045JumpGameII
import spock.lang.Specification

class L045JumpGameIITest extends Specification {
    def "jump game II"() {
        expect:
        L045JumpGameII.calculateStepsA(A as int[]) == res

        where:
        A                                    || res
        [2, 3, 1, 1, 4]                      || 2
        []                                   || -1
        [5]                                  || 0
        [5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0] || 3

    }
}


