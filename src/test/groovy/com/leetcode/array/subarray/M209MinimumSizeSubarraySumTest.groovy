package com.leetcode.array.subarray

import com.leetcode.doublepointers.M209MinimumSizeSubarraySum
import spock.lang.Specification

class M209MinimumSizeSubarraySumTest extends Specification {

    def "minimum size subarray sum"() {
        expect:
        M209MinimumSizeSubarraySum.minSubArrayLenDP(target, nums as int[]) == res

        where:
        target | nums                     || res
        7      | [2, 3, 1, 2, 4, 3]       || 2
        11     | [1, 2, 3, 4, 5]          || 3
        4      | [1, 4, 4]                || 1
        11     | [1, 1, 1, 1, 1, 1, 1, 1] || 0

    }
}

