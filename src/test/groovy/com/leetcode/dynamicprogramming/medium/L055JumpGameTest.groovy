package com.leetcode.dynamicprogramming.medium

import com.leetcode.dynamicprogramming.medium.L055JumpGame
import spock.lang.Specification

class L055JumpGameTest extends Specification {

    def "jump game" (){
        expect:
        L055JumpGame.canJump(A as int[]) == res

        where:
        A || res
        [2,3,1,1,4] || true
        [3,2,1,0,4] || false

    }
}
