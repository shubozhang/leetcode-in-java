package com.leetcode.graphsearch

import spock.lang.Specification

import static groovy.test.GroovyTestCase.assertEquals

class M78SubsetsTest extends Specification {

    def "find subsets recursive version"() {
        when:
        List<List<Integer>> res = M78Subsets.findA(nums as int[])
        Arrays.sort(res)
        Arrays.sort(expected)

        then:
        assertEquals(expected.size(), res.size())

        where:
        nums      || expected
        [1, 2, 3] || [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        [0]       || [[], [0]]
    }

    def "find subsets non-recursive version"() {
        when:
        List<List<Integer>> res = M78Subsets.findB(nums as int[])
        Arrays.sort(res)
        Arrays.sort(expected)

        then:
        assertEquals(expected.size(), res.size())

        where:
        nums      || expected
        [1, 2, 3] || [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        [0]       || [[], [0]]
    }
}
