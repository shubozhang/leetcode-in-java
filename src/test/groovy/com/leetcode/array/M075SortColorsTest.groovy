package com.leetcode.array

import com.leetcode.array.twopointers.M075SortColors
import spock.lang.Specification

class M075SortColorsTest extends Specification {
    def "sort colors by version A"() {
        expect:
        M075SortColors.sortA(nums as int[]) == res as int[]

        where:
        nums               || res
        [2, 0, 2, 1, 1, 0] || [0, 0, 1, 1, 2, 2]
        [2, 0, 1]          || [0, 1, 2]
    }

    def "sort colors by version B"() {
        expect:
        M075SortColors.sortB(nums as int[]) == res as int[]

        where:
        nums               || res
        [2, 0, 2, 1, 1, 0] || [0, 0, 1, 1, 2, 2]
        [2, 0, 1]          || [0, 1, 2]
    }
}
