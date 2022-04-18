package com.leetcode.array.subarray

import spock.lang.Specification

class E121BestTimeToBuyAndSellStockTest extends Specification {

    def "best time to buy and sell stock"() {
        expect:
        E121BestTimeToBuyAndSellStock.maxProfit(prices as int[]) == maxProfit

        where:
        prices             || maxProfit
        [7, 1, 5, 3, 6, 4] || 5
        [7, 6, 4, 3, 1]    || 0
    }
}
