package com.leetcode.misc;


import java.util.HashMap;
import java.util.Map;

/**
 An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

 Given an integer n, return true if n is an ugly number.



 Example 1:

 Input: n = 6
 Output: true
 Explanation: 6 = 2 × 3
 Example 2:

 Input: n = 1
 Output: true
 Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3,
 and 5.
 Example 3:

 Input: n = 14
 Output: false
 Explanation: 14 is not ugly since it includes the prime factor 7.


 Constraints:

 -231 <= n <= 231 - 1
 * */
public class E263UglyNumber {
    public boolean isUgly(int n) {
        if (n < 1) { return false;}

        n = calUgly(n, 2);
        n = calUgly(n, 3);
        n = calUgly(n, 5);

        return (n == 1);
    }

    private int calUgly(int n, int factor) {
        while (n % factor == 0) {
            n /= factor;
        }

        return n;
    }

}
