package com.leetcode.array.subarray

import spock.lang.Specification

class E053MaximumSubarrayTest extends Specification {

    def "max sub array"() {
        expect:
        E053MaximumSubarray.maxSubArray(nums as int[]) == res

        where:
        nums                            || res
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
        [5, 4, -1, 7, 8]                || 23
        [1]                             || 1
    }
}
