package com.lintcode.dynamicprogramming.medium

import spock.lang.Specification

class T117JumpGameIITest extends Specification {
    def "jump game II"() {
        expect:
        T117JumpGameII.calculateStepsA(A as int[]) == res

        where:
        A                                    || res
        [2, 3, 1, 1, 4]                      || 2
        []                                   || -1
        [5]                                  || 0
        [5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0] || 3

    }
}


