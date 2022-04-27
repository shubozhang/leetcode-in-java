package com.leetcode

import com.leetcode.string.E028StrStr
import spock.lang.Specification

class E028StrStrTest extends Specification {

    def "test strstr"() {
        expect:
        E028StrStr.strStr(sourceStr, subStr) == index

        where:
        sourceStr   | subStr || index
        null        | "abc"  || -1
        "abc"       | null   || -1
        null        | null   || -1
        "ab"        | "abc"  || -1
        "ab"        | "bcd"  || -1
        ""          | ""     || 0
        "a"         | ""     || 0
        "abc"       | "abc"  || 0
        "abcde"     | "ab"   || 0
        "abcde"     | "bcde" || 1
        "abcde"     | "cd"   || 2
        "abcde"     | "d"    || 3
        "abcde"     | "e"    || 4
        "abcdeeeee" | "e"    || 4
        "abcabc"    | "bc"   || 1
    }
}
