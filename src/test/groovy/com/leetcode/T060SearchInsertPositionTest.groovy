package com.leetcode

import spock.lang.Specification

class T060SearchInsertPositionTest extends Specification {

    def "test search insert positon"() {
        expect:
        T060SearchInsertPosition.getPosition(arr as int[], target) == index

        where:
        arr                 | target || index
        [1, 2, 3]           | 2      || 1
        [1, 2, 3, 4, 5, 10] | 10     || 5
        [1, 2, 3, 4, 5, 10] | 20     || 6
        []                  | 20     || 0
        [1, 3, 5, 6]        | 5      || 2
        [1, 3, 5, 6]        | 2      || 1
        [1, 3, 5, 6]        | 7      || 4
        [1, 3, 5, 6]        | 0      || 0
    }
}
