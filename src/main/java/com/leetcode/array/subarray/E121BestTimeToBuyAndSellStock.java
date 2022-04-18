package com.leetcode.array.subarray;


/**
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a
 different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
 return 0.

 Example 1:
 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 Example 2:
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.

 Constraints:
 1) 1 <= prices.length <= 105
 2) 0 <= prices[i] <= 104
 * */
public class E121BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // DP problem:
        // f[i] means the max profit when selling on day_i
        // f[i] init value is 0, if (f[i - 1] + prices[i] - prices[i - 1]) <= 0, f[i] still equals 0
        // f[i] = max(f[i], (f[i - 1] + prices[i] - prices[i - 1]))
        int[] f = new int[prices.length];
        f[0] = 0;
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            f[i] = Math.max(f[i], (f[i - 1] + prices[i] - prices[i - 1]));
            res = Math.max(res, f[i]);
        }

        return res;
    }
}
