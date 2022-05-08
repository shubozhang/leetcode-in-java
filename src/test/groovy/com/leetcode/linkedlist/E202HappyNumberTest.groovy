package com.leetcode.linkedlist

import spock.lang.Specification

class E202HappyNumberTest extends Specification {

    def "find happy number - fast / slow pointers"() {
        expect:
        new E202HappyNumber().isHappy(n) == res

        where:
        n  || res
        19 || true
        2  || false
    }

    def "find happy number - HashSet"() {
        expect:
        new E202HappyNumber().isHappyB(n) == res

        where:
        n  || res
        19 || true
        2  || false
    }
}
