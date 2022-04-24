package com.leetcode.binarysearch.easy


import spock.lang.Specification

class L240Search2DMatrixIITest extends Specification {

    def "search target in 2D Matrix II"() {
        expect:
        L240Search2DMarixII.search(source as int[][], target) == result

        where:
        source                                                                                                | target || result
        [[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]] | 5      || true
        [[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]] | 20     || false

    }
}
