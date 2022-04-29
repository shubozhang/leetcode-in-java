package com.leetcode.divideandconquer

import spock.lang.Specification

class M215KthLargestElementInAnArrayTest extends Specification {

    def "find kth largest element in an array"() {
        expect:
        M215KthLargestElementInAnArray.find(nums as int[], k) == res

        where:
        nums                        | k || res
        [3, 2, 1, 5, 6, 4]          | 2 || 5
        [3, 2, 3, 1, 2, 4, 5, 5, 6] | 4 || 4
    }
}
