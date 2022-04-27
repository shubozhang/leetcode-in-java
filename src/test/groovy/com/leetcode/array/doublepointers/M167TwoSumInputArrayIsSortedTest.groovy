package com.leetcode.array.doublepointers

import com.leetcode.doublepointers.M167TwoSumInputArrayIsSorted
import spock.lang.Specification

class M167TwoSumInputArrayIsSortedTest extends Specification {

    def "two sum input array is sorted"() {
        expect:
        M167TwoSumInputArrayIsSorted.twoSum(nums as int[], target) == res as int[]

        where:
        nums           | target || res
        [2, 7, 11, 15] | 9      || [1, 2]
        [2, 3, 4]      | 6      || [1, 3]
        [-1, 0]        | -1     || [1, 2]
    }
}
