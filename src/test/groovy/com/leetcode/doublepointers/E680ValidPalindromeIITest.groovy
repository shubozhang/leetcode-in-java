package com.leetcode.doublepointers

import spock.lang.Specification

class E680ValidPalindromeIITest extends Specification {

    def "validate palindrome II"() {
        expect:
        E680ValidPalindromeII.checkA(str) == res

        where:
        str                     || res
        "ebcbbececabbacecbbcbe" || true
        "aba"                   || true
        "abca"                  || true
        "abc"                   || false

    }
}
