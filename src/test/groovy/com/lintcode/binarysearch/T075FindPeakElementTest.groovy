package com.lintcode.binarysearch

import com.lintcode.binarysearch.medium.T075FindPeakElement
import spock.lang.Specification

class T075FindPeakElementTest extends Specification {

    def "find peak element"() {
        expect:
        (result as int[]).contains(T075FindPeakElement.findPeak(arr as int[]))

        where:
        arr                      || result
        [1, 2, 1, 3, 4, 5, 7, 6] || [1, 6]
        [1, 2, 3, 4, 1]          || [3]
    }
}
