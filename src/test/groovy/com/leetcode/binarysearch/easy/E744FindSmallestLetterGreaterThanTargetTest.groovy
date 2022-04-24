package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.E744FindSmallestLetterGreaterThanTarget
import spock.lang.Specification

class E744FindSmallestLetterGreaterThanTargetTest extends Specification {

    def "L744 find smallest letter greater than target"() {
        expect:
        E744FindSmallestLetterGreaterThanTarget.nextGreatestLetter(letters as char[], target as char) == res as char

        where:
        letters         | target || res
        ['c', 'f', 'j'] | 'a'    || 'c'
        ['c', 'f', 'j'] | 'c'    || 'f'
        ['c', 'f', 'j'] | 'd'    || 'f'
        ['c', 'f', 'j'] | 'j'    || 'c'
        ['c', 'f', 'j'] | 'm'    || 'c'
    }
}
