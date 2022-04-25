package com.leetcode.array.sortedarray

import spock.lang.Specification

class E1608SpecialArrayWithXElementsGreaterThanOrEqualXTest extends Specification {

    def "special array with x elements greater than or equal x"() {
        expect:
        E1608SpecialArrayWithXElementsGreaterThanOrEqualX.specialArray(nums as int[]) == res

        where:
        nums            || res
        [3, 5]          || 2
        [0, 0]          || -1
        [0, 4, 3, 0, 4] || 3
        [3,6,7,7,0]     || -1
    }
}
