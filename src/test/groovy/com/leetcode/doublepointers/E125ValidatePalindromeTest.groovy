package com.leetcode.doublepointers

import com.leetcode.doublepointers.E125ValidatePalindrome
import spock.lang.Specification

class E125ValidatePalindromeTest extends Specification {

    def "palindrome version A"() {
        expect:
        E125ValidatePalindrome.checkA(str) == res

        where:
        str                              || res
        ""                               || true
        null                             || false
        "a"                              || true
        "1a2"                            || false
        "abc"                            || false
        "aaa"                            || true
        "abccba"                         || true
        "A man, a plan, a canal: Panama" || true
        "race a car"                     || false

    }

    def "palindrome version B"() {
        expect:
        E125ValidatePalindrome.checkB(str) == res

        where:
        str                              || res
        ""                               || true
        null                             || false
        "a"                              || true
        "1a2"                            || false
        "abc"                            || false
        "aaa"                            || true
        "abccba"                         || true
        "A man, a plan, a canal: Panama" || true
        "race a car"                     || false

    }
}
