package com.leetcode.array

import com.leetcode.array.twopointers.M075SortColors
import spock.lang.Specification

class M075SortColorsTest extends Specification {
    def "sort colors"() {
        expect:
        M075SortColors.sort(nums as int[]) == res as int[]

        where:
        nums               || res
        [2, 0, 2, 1, 1, 0] || [0, 0, 1, 1, 2, 2]
        [2, 0, 1]          || [0, 1, 2]
    }
}
