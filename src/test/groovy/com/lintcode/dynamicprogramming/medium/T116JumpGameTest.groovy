package com.lintcode.dynamicprogramming.medium

import spock.lang.Specification

class T116JumpGameTest extends Specification {

    def "jump game" (){
        expect:
        T116JumpGame.canJump(A as int[]) == res

        where:
        A || res
        [2,3,1,1,4] || true
        [3,2,1,0,4] || false

    }
}
