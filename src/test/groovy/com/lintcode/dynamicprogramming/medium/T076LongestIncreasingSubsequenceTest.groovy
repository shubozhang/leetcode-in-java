package com.lintcode.dynamicprogramming.medium

import spock.lang.Specification

class T076LongestIncreasingSubsequenceTest extends Specification {

    def "longest increasing subsequence"() {
        expect:
        T076LongestIncreasingSubsequence.search(A as int[]) == res

        where:
        A                  || res
        [5, 4, 1, 2, 3]    || 3
        [4, 2, 4, 5, 3, 7] || 4

    }
}
