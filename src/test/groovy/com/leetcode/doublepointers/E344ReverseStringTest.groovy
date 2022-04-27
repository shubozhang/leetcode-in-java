package com.leetcode.doublepointers

import spock.lang.Specification

class E344ReverseStringTest extends Specification {

    def "reverse string"() {
        expect:
        E344ReverseString.reverse(s as char[]) == res

        where:
        s                              || res
        ["h", "e", "l", "l", "o"]      || ["o", "l", "l", "e", "h"]
        ["H", "a", "n", "n", "a", "h"] || ["h", "a", "n", "n", "a", "H"]

    }
}
