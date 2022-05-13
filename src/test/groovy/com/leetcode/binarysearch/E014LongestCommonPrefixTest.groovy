package com.leetcode.binarysearch

import spock.lang.Specification

class E014LongestCommonPrefixTest extends Specification {

    def "find longest sonmmon prefiex"() {
        expect:
        new E014LongestCommonPrefix().longestCommonPrefix(strs as String[]) == res

        where:
        strs                         || res
        ["flower", "flow", "flight"] || "fl"
        ["dog", "racecar", "car"]    || ""
        ["abc"]                      || "abc"

    }
}
