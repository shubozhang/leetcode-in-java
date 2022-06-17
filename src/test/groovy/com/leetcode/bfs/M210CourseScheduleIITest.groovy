package com.leetcode.bfs

import spock.lang.Specification

class M210CourseScheduleIITest extends Specification {

    def "course schedule II"() {
        expect:
        new M210CourseScheduleII().findOrder(num as int, prerequisites as int[][]) == res

        where:
        num | prerequisites                    || res
        2   | []                               || [0, 1]
        2   | [[1, 0]]                         || [0, 1]
        2   | [[0, 1]]                         || [1, 0]
        3   | [[0, 1]]                         || [1, 2, 0]
        4   | [[1, 0], [2, 0], [3, 1], [3, 2]] || [0, 1, 2, 3]
    }
}
