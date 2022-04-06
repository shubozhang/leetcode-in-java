package com.lintcode.binarysearch

import com.lintcode.binarysearch.medium.T062SearchInRotatedSortedArray
import spock.lang.Specification

class T062SearchInRotatedSortedArrayTest extends Specification {

    def "search in rotated sorted array without dup"() {
        expect:
        T062SearchInRotatedSortedArray.search(nums as int[], target) == index

        where:
        nums            | target || index
        [4, 5, 1, 2, 3] | 1      || 2
        [4, 5, 1, 2, 3] | 0      || -1
        null            | 0      || -1
        []              | 0      || -1
    }
}
