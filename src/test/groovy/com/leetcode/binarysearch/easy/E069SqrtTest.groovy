package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.E069Sqrt
import spock.lang.Specification

class E069SqrtTest extends Specification {

    def "L069 find sqrt x"() {
        expect:
        E069Sqrt.mySqrt(x) == root

        where:
        x                 || root
        4                 || 2
        8                 || 2
        1                 || 1
        2                 || 1
        9                 || 3
        10                || 3
        101               || 10
        Integer.MAX_VALUE || 46340
    }
}
