package com.leetcode.bfs

import spock.lang.Specification

class M200NumberOfIslandsTest extends Specification {

    def "number of islands"() {
        expect:
        M200NumberOfIslands.numIslands(grid as char[][]) == res

        where:
        grid || res
        [
                ["1", "1", "1", "1", "0"],
                ["1", "1", "0", "1", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "0", "0", "0"]
        ]    || 1
        [
                ["1", "1", "0", "0", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "1", "0", "0"],
                ["0", "0", "0", "1", "1"]
        ]    || 3


    }
}
