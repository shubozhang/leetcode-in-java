package com.leetcode.array.doublepointers

import com.leetcode.doublepointers.E001TwoSum
import spock.lang.Specification

class E001TwoSumTest extends Specification {

    def "find two sum"() {
        expect:
        E001TwoSum.twoPointers(nums as int[], target) == res as int[]

        where:
        nums                 | target || res
        [2, 7, 11, 15]       | 9      || [0, 1]
        [3, 2, 4]            | 6      || [1, 2]
        [3, 3]               | 6      || [0, 1]
        [2, 5, 5, 11]        | 10     || [1, 2]
        [-1, -2, -3, -4, -5] | -8     || [2, 4]
    }
}
