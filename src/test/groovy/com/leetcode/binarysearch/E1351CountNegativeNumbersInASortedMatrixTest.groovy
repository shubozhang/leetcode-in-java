package com.leetcode.binarysearch

import spock.lang.Specification

class E1351CountNegativeNumbersInASortedMatrixTest extends Specification {

    def "count negative numbers A"() {
        expect:
        E1351CountNegativeNumbersInASortedMatrix.countA(grid as int[][]) == res

        where:
        grid                                                                                                   || res
        [[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]                                       || 8
        [[3, 2], [1, 0]]                                                                                       || 0
        [[4, 3, 3, 1, 1], [1, 0, 0, -1, -1], [-2, -2, -2, -2, -3], [-2, -2, -2, -3, -3], [-3, -3, -3, -3, -3]] || 17
        [[11, 10, 7, 5, 4, 4, 2, 0, 0, -1, -13, -18, -19, -20, -20, -20, -20, -20, -20, -20],
         [11, 10, 7, 4, 4, 4, 2, 0, 0, -2, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [10, 9, 6, 3, 2, 1, 0, 0, 0, -3, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20]]                   || 33
        [[16, 16, 16, 16, 15, 14, 14, 13, 13, 13, 12, -9, -9, -10, -10, -10, -10, -11, -11, -11],
         [15, 14, 14, 14, 14, 13, 13, 12, 11, 10, 9, -9, -10, -11, -12, -13, -14, -14, -14, -14],
         [15, 14, 14, 13, 12, 12, 12, 11, 10, 10, 9, -10, -10, -12, -12, -14, -14, -14, -14, -15],
         [15, 13, 13, 13, 11, 10, 9, 9, 8, 7, 6, -11, -12, -13, -14, -15, -15, -16, -17, -18],
         [14, 13, 12, 12, 11, 9, 8, 7, 7, 6, 5, -11, -12, -13, -15, -16, -16, -17, -17, -19],
         [14, 13, 12, 12, 10, 9, 7, 6, 6, 6, -10, -12, -12, -13, -16, -16, -17, -18, -18, -20],
         [13, 12, 12, 11, 9, 9, 7, 5, 5, 5, -10, -13, -13, -13, -17, -18, -19, -20, -20, -20],
         [13, 12, 11, 11, 8, 7, 7, 4, 3, 2, -10, -14, -15, -16, -18, -18, -20, -20, -20, -20],
         [13, 12, 10, 9, 7, 7, 7, 4, 3, 1, -11, -15, -15, -16, -18, -19, -20, -20, -20, -20],
         [12, 12, 9, 9, 7, 7, 7, 4, 2, 0, -11, -15, -15, -17, -19, -20, -20, -20, -20, -20],
         [12, 11, 8, 7, 7, 6, 6, 3, 2, 0, -11, -15, -15, -18, -20, -20, -20, -20, -20, -20],
         [12, 11, 8, 6, 6, 5, 4, 2, 1, -1, -11, -16, -17, -19, -20, -20, -20, -20, -20, -20],
         [11, 10, 8, 6, 6, 5, 3, 1, 0, -1, -12, -18, -18, -20, -20, -20, -20, -20, -20, -20],
         [11, 10, 7, 5, 4, 4, 2, 0, 0, -1, -13, -18, -19, -20, -20, -20, -20, -20, -20, -20],
         [11, 10, 7, 4, 4, 4, 2, 0, 0, -2, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [10, 9, 6, 3, 2, 1, 0, 0, 0, -3, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 9, 5, 2, -5, -6, -7, -7, -8, -9, -14, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 9, 5, 2, -5, -6, -7, -7, -9, -10, -15, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 8, 5, 1, -6, -7, -8, -9, -9, -11, -15, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [8, 8, 5, -2, -13, -14, -14, -15, -15, -16, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [7, 6, 4, -2, -13, -14, -14, -15, -16, -17, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [6, 5, 4, -2, -13, -14, -14, -15, -17, -18, -19, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [5, 5, -7, -8, -14, -14, -15, -16, -17, -19, -19, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [5, 4, -7, -8, -14, -15, -16, -16, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 4, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 3, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 3, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 2, -8, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 1, -8, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [3, 0, -9, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [2, -1, -10, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [1, -2, -11, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [0, -2, -11, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [-1, -3, -12, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20]]   || 480
    }

    def "count negative numbers B"() {
        expect:
        E1351CountNegativeNumbersInASortedMatrix.countB(grid as int[][]) == res

        where:
        grid                                                                                                   || res
        [[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]                                       || 8
        [[3, 2], [1, 0]]                                                                                       || 0
        [[4, 3, 3, 1, 1], [1, 0, 0, -1, -1], [-2, -2, -2, -2, -3], [-2, -2, -2, -3, -3], [-3, -3, -3, -3, -3]] || 17
        [[16, 16, 16, 16, 15, 14, 14, 13, 13, 13, 12, -9, -9, -10, -10, -10, -10, -11, -11, -11],
         [15, 14, 14, 14, 14, 13, 13, 12, 11, 10, 9, -9, -10, -11, -12, -13, -14, -14, -14, -14],
         [15, 14, 14, 13, 12, 12, 12, 11, 10, 10, 9, -10, -10, -12, -12, -14, -14, -14, -14, -15],
         [15, 13, 13, 13, 11, 10, 9, 9, 8, 7, 6, -11, -12, -13, -14, -15, -15, -16, -17, -18],
         [14, 13, 12, 12, 11, 9, 8, 7, 7, 6, 5, -11, -12, -13, -15, -16, -16, -17, -17, -19],
         [14, 13, 12, 12, 10, 9, 7, 6, 6, 6, -10, -12, -12, -13, -16, -16, -17, -18, -18, -20],
         [13, 12, 12, 11, 9, 9, 7, 5, 5, 5, -10, -13, -13, -13, -17, -18, -19, -20, -20, -20],
         [13, 12, 11, 11, 8, 7, 7, 4, 3, 2, -10, -14, -15, -16, -18, -18, -20, -20, -20, -20],
         [13, 12, 10, 9, 7, 7, 7, 4, 3, 1, -11, -15, -15, -16, -18, -19, -20, -20, -20, -20],
         [12, 12, 9, 9, 7, 7, 7, 4, 2, 0, -11, -15, -15, -17, -19, -20, -20, -20, -20, -20],
         [12, 11, 8, 7, 7, 6, 6, 3, 2, 0, -11, -15, -15, -18, -20, -20, -20, -20, -20, -20],
         [12, 11, 8, 6, 6, 5, 4, 2, 1, -1, -11, -16, -17, -19, -20, -20, -20, -20, -20, -20],
         [11, 10, 8, 6, 6, 5, 3, 1, 0, -1, -12, -18, -18, -20, -20, -20, -20, -20, -20, -20],
         [11, 10, 7, 5, 4, 4, 2, 0, 0, -1, -13, -18, -19, -20, -20, -20, -20, -20, -20, -20],
         [11, 10, 7, 4, 4, 4, 2, 0, 0, -2, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [10, 9, 6, 3, 2, 1, 0, 0, 0, -3, -13, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 9, 5, 2, -5, -6, -7, -7, -8, -9, -14, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 9, 5, 2, -5, -6, -7, -7, -9, -10, -15, -19, -19, -20, -20, -20, -20, -20, -20, -20],
         [9, 8, 5, 1, -6, -7, -8, -9, -9, -11, -15, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [8, 8, 5, -2, -13, -14, -14, -15, -15, -16, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [7, 6, 4, -2, -13, -14, -14, -15, -16, -17, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [6, 5, 4, -2, -13, -14, -14, -15, -17, -18, -19, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [5, 5, -7, -8, -14, -14, -15, -16, -17, -19, -19, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [5, 4, -7, -8, -14, -15, -16, -16, -17, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 4, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 3, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 3, -7, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 2, -8, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [4, 1, -8, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [3, 0, -9, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [2, -1, -10, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [1, -2, -11, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [0, -2, -11, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20],
         [-1, -3, -12, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20]]   || 480
    }
}