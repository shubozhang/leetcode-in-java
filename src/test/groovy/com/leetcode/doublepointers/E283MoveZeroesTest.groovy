package com.leetcode.doublepointers

import spock.lang.Specification

class E283MoveZeroesTest extends Specification {

    def "move zeros" (){

        expect:
        new E283MoveZeroes().moveZeroesA(nums as int[]) == res as int[]

        where:
        nums || res
        [0,1,0,3,12] || [1,3,12,0,0]
        [0] || [0]
    }
}
