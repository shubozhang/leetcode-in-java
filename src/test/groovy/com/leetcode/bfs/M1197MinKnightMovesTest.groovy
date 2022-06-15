package com.leetcode.bfs

import spock.lang.Specification

class M1197MinKnightMovesTest extends Specification {

    def "minimum knight moves by DFS"() {
        expect:
        new M1197MinKnightMoves().minKnightMovesA(x, y) == res

        where:
        x    | y    || res
        2    | 1    || 1
        5    | 5    || 4
        -172 | -110 || 94
    }

    def "minimum knight moves by BFS"() {
        expect:
        new M1197MinKnightMoves().minKnightMovesB(x, y) == res

        where:
        x    | y    || res
        2    | 1    || 1
        5    | 5    || 4
        -172 | -110 || 94
    }
}
