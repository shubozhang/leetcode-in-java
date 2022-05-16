package com.leetcode.string

import spock.lang.Specification

class E387FirstUniqueCharacterInAStringTest extends Specification {
    def "first unique character in a string"() {
        expect:
        new E387FirstUniqueCharacterInAString().firstUniqChar(str) == res

        where:
        str            || res
        "leetcode"     || 0
        "loveleetcode" || 2
        "aabb"         || -1
        "aaabb"        || -1
    }
}
