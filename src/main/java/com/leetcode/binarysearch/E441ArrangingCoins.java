package com.leetcode.binarysearch;


/**
 https://leetcode.com/problems/arranging-coins/
 You have n coins and you want to build a staircase with these coins. The staircase consists
 of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

 Given the integer n, return the number of complete rows of the staircase you will build.

 Example 1:
 Input: n = 5
 Output: 2
 Explanation: Because the 3rd row is incomplete, we return 2.

 Example 2:
 Input: n = 8
 Output: 3
 Explanation: Because the 4th row is incomplete, we return 3.

 Constraints:
 1) 1 <= n <= 231 - 1
 * */
public class E441ArrangingCoins {

    public static int arrangeB(int n) {
        if (n == 1) {
            return n;
        }
        int start = 1;
        int end =n;
        int res = 1;
        long sum ;

        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            sum = mid * (mid + 1) / 2;
            if (n >= sum && n < sum + mid + 1) {
                return (int)mid;
            } else if (n > sum) {
                start = (int)mid;
            } else if (n < sum) {
                end = (int)mid;
            }
        }

        sum = ((long) start * start + start) / 2;
        if (n > sum && n< sum + start + 1){
            return start;
        } else {
            return end;
        }
    }

    public static int arrangeA(int n) {
        if (n == 1) { return 1;}
        int maxSize = n;
        int res = 0;

        for (int i = 1; i < maxSize; i++) {
            if (n >= i) {
                n -= i;
                res++;
            }
            if (n == 0 || n < i + 1) {
                break;
            }
        }

        return res;
    }
}
