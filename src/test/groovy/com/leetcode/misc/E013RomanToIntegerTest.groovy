package com.leetcode.misc

import spock.lang.Specification

class E013RomanToIntegerTest extends Specification {

    def "roman to integer"() {

        expect:
        new E013RomanToInteger().romanToInt(s) == res

        where:
        s         || res
        "III"     || 3
        "LVIII"   || 58
        "MCMXCIV" || 1994

    }
}
