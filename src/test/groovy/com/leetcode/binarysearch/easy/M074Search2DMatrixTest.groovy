package com.leetcode.binarysearch.easy

import com.leetcode.binarysearch.M074Search2DMatrix
import spock.lang.Specification

class M074Search2DMatrixTest extends Specification {

    def "search a 2D matrix"() {
        expect:
        M074Search2DMatrix.searchMatrix(source as int[][], target) == result

        where:
        source                                             | target || result
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 11     || true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 3      || true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 0      || false
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 51     || false
        null                                               | 51     || false
        [][]                                               | 51     || false
    }
}
