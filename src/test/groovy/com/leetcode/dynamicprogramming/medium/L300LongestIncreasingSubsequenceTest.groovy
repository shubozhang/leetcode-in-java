package com.leetcode.dynamicprogramming.medium

import com.leetcode.dynamicprogramming.medium.L300LongestIncreasingSubsequence
import spock.lang.Specification

class L300LongestIncreasingSubsequenceTest extends Specification {

    def "longest increasing subsequence"() {
        expect:
        L300LongestIncreasingSubsequence.search(A as int[]) == res

        where:
        A                  || res
        [5, 4, 1, 2, 3]    || 3
        [4, 2, 4, 5, 3, 7] || 4

    }
}
