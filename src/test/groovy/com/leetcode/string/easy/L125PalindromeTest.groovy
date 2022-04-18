package com.leetcode.string.easy

import spock.lang.Specification

class L125PalindromeTest extends Specification {

    def "palindrome"() {
        expect:
        L125Palindrome.isPalindrome(str) == res

        where:
        str      || res
        ""       || true
        null     || false
        "a"      || true
        "1a2"    || false
        "abc"    || false
        "aaa"    || true
        "abccba" || true

    }
}
