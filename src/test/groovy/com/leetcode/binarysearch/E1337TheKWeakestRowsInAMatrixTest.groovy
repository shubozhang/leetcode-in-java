package com.leetcode.binarysearch

import spock.lang.Specification

class E1337TheKWeakestRowsInAMatrixTest extends Specification {

    def "find the k weakes rows in a matrix"() {
        expect:
        E1337TheKWeakestRowsInAMatrix.findA(mat as int[][], k) == res

        where:
        mat                                                          | k || res
        [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]] | 1 || [0]
        [[1, 1, 0, 0, 0],
         [1, 1, 1, 1, 0],
         [1, 0, 0, 0, 0],
         [1, 1, 0, 0, 0],
         [1, 1, 1, 1, 1]]                                            | 3 || [2, 0, 3]
        [[1, 0, 0, 0],
         [1, 1, 1, 1],
         [1, 0, 0, 0],
         [1, 0, 0, 0]]                                               | 2 || [0, 2]
    }
}
