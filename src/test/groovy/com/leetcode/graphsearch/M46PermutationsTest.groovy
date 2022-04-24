package com.leetcode.graphsearch

import spock.lang.Specification

class M46PermutationsTest extends Specification {

    def "permutations"() {
        expect:
        M46Permutations.permute(nums as int[]) == res as int[][]

        where:
        nums      || res
        [1, 2, 3] || [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        [0, 1]    || [[0, 1], [1, 0]]
        [1]       || [[1]]
    }
}
