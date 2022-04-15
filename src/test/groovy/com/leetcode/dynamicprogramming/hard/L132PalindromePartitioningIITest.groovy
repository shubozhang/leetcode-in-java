package com.leetcode.dynamicprogramming.hard

import spock.lang.Specification

class L132PalindromePartitioningIITest extends Specification {

    def "palindrome patitioning II"() {
        expect:
        L132PalindromePartitioningII.minCut(s) == res

        where:
        s     || res
        "aab" || 1
    }
}

//         "a"   || 0
