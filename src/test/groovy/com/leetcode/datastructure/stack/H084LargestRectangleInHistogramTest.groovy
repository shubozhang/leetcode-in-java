package com.leetcode.datastructure.stack

import com.leetcode.datastructure.H084LargestRectangleInHistogram
import spock.lang.Specification

class H084LargestRectangleInHistogramTest extends Specification {

    def "find largest rectangle in histogram"() {
        expect:
        H084LargestRectangleInHistogram.largestRectangleArea(heights as int[]) == res

        where:
        heights            || res
        [2, 1, 5, 6, 2, 3] || 10
        [2, 4]             || 4
    }
}
