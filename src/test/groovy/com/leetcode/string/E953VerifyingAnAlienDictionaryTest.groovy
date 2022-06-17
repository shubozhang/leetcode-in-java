package com.leetcode.string

import spock.lang.Specification

class E953VerifyingAnAlienDictionaryTest extends Specification {

    def "verifying an alien dictionary A"() {
        expect:
        new E953VerifyingAnAlienDictionary().isAlienSortedA(words as String[], order) == res

        where:
        words                    | order                        || res
        ["hello", "leetcode"]    | "hlabcdefgijkmnopqrstuvwxyz" || true
        ["word", "world", "row"] | "worldabcefghijkmnpqstuvxyz" || false
        ["apple", "app"]         | "abcdefghijklmnopqrstuvwxyz" || false

    }

    def "verifying an alien dictionary B"() {
        expect:
        new E953VerifyingAnAlienDictionary().isAlienSortedB(words as String[], order) == res

        where:
        words                    | order                        || res
        ["hello", "leetcode"]    | "hlabcdefgijkmnopqrstuvwxyz" || true
        ["word", "world", "row"] | "worldabcefghijkmnpqstuvxyz" || false
        ["apple", "app"]         | "abcdefghijklmnopqrstuvwxyz" || false

    }

    def "verifying an alien dictionary C"() {
        expect:
        new E953VerifyingAnAlienDictionary().isAlienSortedC(words as String[], order) == res

        where:
        words                    | order                        || res
        ["hello", "leetcode"]    | "hlabcdefgijkmnopqrstuvwxyz" || true
        ["word", "world", "row"] | "worldabcefghijkmnpqstuvxyz" || false
        ["apple", "app"]         | "abcdefghijklmnopqrstuvwxyz" || false

    }
}
