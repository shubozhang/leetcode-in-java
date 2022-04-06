package com.leetcode.binarysearch.easy;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer
 * part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5)
 * or x ** 0.5.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 * 0 <= x <= 231 - 1
 *
 * @author shubozhang
 */
public class L069Sqrt {
    public static int mySqrt(int x) {
        if (x == 1) { return 1;}

        int start = 1;
        int end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (x / (mid + 1) >= (mid + 1)) {
                start = mid;
            } else if (x / mid >= mid) {
                return mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return end;
        } else {
            return start;
        }
    }
}
