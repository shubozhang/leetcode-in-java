package com.leetcode.doublepointers

import spock.lang.Specification

class M454FourSumIITest extends Specification {

    def "four sum II"() {
        expect:
        new M454FourSumII().fourSumCount(num1 as int[], num2 as int[], num3 as int[], num4 as int[]) == res

        where:
        num1   | num2     | num3    | num4   || res
        [1, 2] | [-2, -1] | [-1, 2] | [0, 2] || 2
        [0]    | [0]      | [0]     | [0]    || 1


    }
}
