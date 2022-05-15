package com.leetcode.string

import spock.lang.Specification

class E415AddStringsTest extends Specification {

    def "add two strings"() {
        expect:
        new E415AddStrings().addStrings(num1, num2) == res

        where:
        num1  | num2  || res
        "11"  | "123" || "134"
        "456" | "77"  || "533"
        "0"   | "0"   || "0"
        "1"   | "9"   || "10"
        "9"   | "99"  || "108"
    }
}
