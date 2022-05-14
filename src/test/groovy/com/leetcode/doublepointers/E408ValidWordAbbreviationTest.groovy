package com.leetcode.doublepointers

import spock.lang.Specification

class E408ValidWordAbbreviationTest extends Specification {

    def "valid word abbreviation"() {

        expect:
        new E408ValidWordAbbreviation().validWordAbbreviation(word, abbreviation) == res

        where:
        word                   | abbreviation || res
        "internationalization" | "i5a11o1"    || true
        "substitution"         | "s10n"       || true
        "substitution"         | "s55n"       || false
        "internationalization" | "i12iz4n"    || true
        "apple"                | "a2e"        || false


    }
}
